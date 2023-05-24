package com.example.app_huangbowei.fragment;

import android.app.DatePickerDialog;
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
    // 定义日历变量，用于获取当前日期
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private NumberPicker numberPicker;
    private TextView tvRemainingTicketsCount; // 剩余票量显示文本框
    private RadioGroup rgTimeSlot; // 时间段选择器
    private int remainingTickets; // 剩余票量

    public int getLayoutResId() {
        return R.layout.fragment_ticket;
    }

    public void initView(View rootView) {
        // 初始化视图组件
        //数量选择器
        numberPicker = rootView.findViewById(R.id.number_picker);

        // 设置数量选择器的最小值和最大值
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        //时间选择器
        tvBirthday = rootView.findViewById(R.id.tvBirthday);
        btnSelectDate = rootView.findViewById(R.id.btnSelectDate);
        // 初始化日历变量，获取当前日期
        calendar = Calendar.getInstance();

        // 设置出生年月日显示文本框的默认值为当前日期，格式为年/月/日
        tvBirthday.setText(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH));

        // 设置选择日期按钮的点击事件监听器，弹出日期选择对话框，让用户选择出生年月日
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 初始化日期选择对话框，参数为当前活动、监听器、年、月、日
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 当用户选择日期后，更新出生年月日显示文本框的值，格式为年/月/日
                        tvBirthday.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show(); // 显示日期选择对话框
            }
        });

        // 初始化剩余票量和剩余票量显示文本框
        remainingTickets = 0;
        tvRemainingTicketsCount = rootView.findViewById(R.id.tv_remaining_tickets_count);

        // 初始化时间段选择器和时间段选择监听器
        rgTimeSlot = rootView.findViewById(R.id.radio_group_time_slot);
        rgTimeSlot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 根据选中的时间段更新剩余票量的显示
                if (checkedId == R.id.radio_morning) {
                    remainingTickets = (int) (Math.random() * 11) + 20; // 上午剩余票量为20~30中的某个数字
                } else if (checkedId == R.id.radio_afternoon) {
                    remainingTickets = (int) (Math.random() * 11) + 30; // 下午剩余票量为30~40中的某个数字
                }
                tvRemainingTicketsCount.setText(String.valueOf(remainingTickets));
            }
        });

        // 初始化预订门票按钮和点击事件监听器
        Button btnBookTicket = rootView.findViewById(R.id.btn_book_ticket);
        btnBookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取购买的门票数量
                int quantity = numberPicker.getValue();
                // 更新剩余票量的显示
                remainingTickets -= quantity;
                tvRemainingTicketsCount.setText(String.valueOf(remainingTickets));
                // 弹出购票成功的提示
                Toast.makeText(getActivity(), "购票成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initData() {
        // 加载数据
    }
}
