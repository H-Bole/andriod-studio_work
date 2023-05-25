package com.example.app_huangbowei.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_huangbowei.R;

import java.util.Calendar;

//门票类
public class TicketFragment extends BaseFragment {
    private TextView tvBirthday; // 出生年月日显示文本框
    private Button btnSelectDate; // 选择日期按钮
    private Calendar calendar; // 日历变量，用于获取当前日期
    private DatePickerDialog datePickerDialog; // 日期选择对话框
    private NumberPicker numberPicker; // 数量选择器
    private TextView tvRemainingTicketsCount; // 剩余票量显示文本框
    private RadioGroup rgTimeSlot; // 时间段选择器
    private int remainingTickets; // 剩余票量

    public int getLayoutResId() {
        return R.layout.fragment_ticket;
    }

    public void initView(View rootView) {
        // 初始化视图组件
        numberPicker = rootView.findViewById(R.id.number_picker);
        numberPicker.setMinValue(1); // 设置数量选择器的最小值
        numberPicker.setMaxValue(10); // 设置数量选择器的最大值

        tvBirthday = rootView.findViewById(R.id.tvBirthday);
        btnSelectDate = rootView.findViewById(R.id.btnSelectDate);
        calendar = Calendar.getInstance(); // 获取当前日期
        tvBirthday.setText(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH)); // 设置出生年月日显示文本框的默认值为当前日期，格式为年/月/日
        btnSelectDate.setOnClickListener(v -> {
            // 初始化日期选择对话框，参数为当前活动、监听器、年、月、日
            datePickerDialog = new DatePickerDialog(getActivity(), (view, year, month, dayOfMonth) -> tvBirthday.setText(year + "/" + (month + 1) + "/" + dayOfMonth), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show(); // 显示日期选择对话框
        });

        remainingTickets = 0;
        tvRemainingTicketsCount = rootView.findViewById(R.id.tv_remaining_tickets_count);

        rgTimeSlot = rootView.findViewById(R.id.radio_group_time_slot);
        rgTimeSlot.setOnCheckedChangeListener((group, checkedId) -> {
            // 根据选中的时间段更新剩余票量的显示
            remainingTickets = checkedId == R.id.radio_morning ? (int) (Math.random() * 11) + 20 : (int) (Math.random() * 11) + 30;
            tvRemainingTicketsCount.setText(String.valueOf(remainingTickets));
        });

        Button btnBookTicket = rootView.findViewById(R.id.btn_book_ticket);
        btnBookTicket.setOnClickListener(v -> {
            int quantity = numberPicker.getValue(); // 获取购买的门票数量
            remainingTickets -= quantity; // 更新剩余票量的显示
            tvRemainingTicketsCount.setText(String.valueOf(remainingTickets));
            Toast.makeText(getActivity(), "购票成功", Toast.LENGTH_SHORT).show(); // 弹出购票成功的提示

            // 保存购票信息到SharedPreferences中
            SharedPreferences sp = getActivity().getSharedPreferences("ticket_info", Context.MODE_PRIVATE);
            sp.edit()
                    .putString("date", tvBirthday.getText().toString()) // 保存日期
                    .putInt("quantity", quantity) // 保存数量
                    .putInt("time_slot", rgTimeSlot.getCheckedRadioButtonId()) // 保存时间段
                    .apply(); // 使用apply()方法保存数据，更加高效
        });
    }

    public void initData() {
        // 加载数据
    }
}
