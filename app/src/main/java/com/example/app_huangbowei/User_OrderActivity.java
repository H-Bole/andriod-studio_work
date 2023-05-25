package com.example.app_huangbowei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class User_OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        getSupportActionBar().hide();

        // 读取SharedPreferences中保存的购票信息
        SharedPreferences sp = getSharedPreferences("ticket_info", Context.MODE_PRIVATE);
        String date = sp.getString("date", "");
        int quantity = sp.getInt("quantity", 0);
        int timeSlotId = sp.getInt("time_slot", -1);

        // 显示购票信息
        TextView tvDate = findViewById(R.id.tv_date);
        TextView tvQuantity = findViewById(R.id.tv_quantity);
        TextView tvTimeSlot = findViewById(R.id.tv_time_slot);

        tvDate.setText(date);
        tvQuantity.setText(String.valueOf(quantity));
        if (timeSlotId == R.id.radio_morning) {
            tvTimeSlot.setText("上午");
        } else if (timeSlotId == R.id.radio_afternoon) {
            tvTimeSlot.setText("下午");
        }
    }
}
