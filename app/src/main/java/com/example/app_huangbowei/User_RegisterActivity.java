package com.example.app_huangbowei;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_huangbowei.fragment.User_centerFragment;

import java.util.Calendar;

public class User_RegisterActivity extends AppCompatActivity {

    private EditText accountEditText;
    private EditText passwordEditText;
//    新方法
    private CheckBox cb1, cb2, cb3, cb4; //声明四个CheckBox对象
    private TextView tvBirthday; // 出生年月日显示文本框
    private Button btnSelectDate; // 选择日期按钮
    // 定义日期选择对话框变量
    private DatePickerDialog datePickerDialog;

    // 定义日历变量，用于获取当前日期
    private Calendar calendar;
    private RadioGroup rgGender; // 性别单选按钮组
    private RadioButton rbMale; // 男性单选按钮
    private RadioButton rbFemale; // 女性单选按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        //时间选择器
        tvBirthday = findViewById(R.id.tvBirthday);
        btnSelectDate=findViewById(R.id.btnSelectDate);
        //获取布局文件中的CheckBox控件
        cb1 = findViewById(R.id.cb_1);
        cb2 = findViewById(R.id.cb_2);
        cb3 = findViewById(R.id.cb_3);
        cb4 = findViewById(R.id.cb_4);
        // 初始化日历变量，获取当前日期
        calendar = Calendar.getInstance();

        // 设置出生年月日显示文本框的默认值为当前日期，格式为年/月/日
        tvBirthday.setText(calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH));

        // 设置选择日期按钮的点击事件监听器，弹出日期选择对话框，让用户选择出生年月日
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 初始化日期选择对话框，参数为当前活动、监听器、年、月、日
                datePickerDialog = new DatePickerDialog(User_RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 当用户选择日期后，更新出生年月日显示文本框的值，格式为年/月/日
                        tvBirthday.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show(); // 显示日期选择对话框
            }
        });

        //设置默认选中第一个和第二个选项
        cb1.setChecked(true);
        cb2.setChecked(true);

        //为每个CheckBox设置点击监听器
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断是否被选中，并弹出提示信息
                if (cb1.isChecked()) {
                    Toast.makeText(User_RegisterActivity.this, "你选择了" + cb1.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User_RegisterActivity.this, "你取消了" + cb1.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb2.isChecked()) {
                    Toast.makeText(User_RegisterActivity.this, "你选择了" + cb2.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User_RegisterActivity.this, "你取消了" + cb2.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb3.isChecked()) {
                    Toast.makeText(User_RegisterActivity.this, "你选择了" + cb3.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User_RegisterActivity.this, "你取消了" + cb3.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb4.isChecked()) {
                    Toast.makeText(User_RegisterActivity.this, "你选择了" + cb4.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User_RegisterActivity.this, "你取消了" + cb4.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        accountEditText = findViewById(R.id.account_edittext1);
        passwordEditText = findViewById(R.id.password_edittext1);

        Button registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // 保存账号和密码到SharedPreferences中
                SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password", password);
                editor.putString("account", account);
                editor.putString("nickname", "未登录"); // 设置昵称为"未登录"
                editor.apply();


                // 返回账号和密码到LoginActivity中
                Intent intent = new Intent(User_RegisterActivity.this, User_LoginActivity.class);
                intent.putExtra("account", account);
                intent.putExtra("password", password);
                startActivity(intent);
                // 返回账号和密码到User_centerFragment中
                Intent intent1 = new Intent(User_RegisterActivity.this,User_centerFragment.class);
                intent1.putExtra("account", account);
                intent1.putExtra("nickname", "未登录");
                setResult(RESULT_OK, intent1);
                Toast.makeText(User_RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
