package com.example.app_huangbowei;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_huangbowei.fragment.User_centerFragment;

public class RegisterActivity extends AppCompatActivity {

    private EditText accountEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

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
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("account", account);
                intent.putExtra("password", password);
                startActivity(intent);
                // 返回账号和密码到User_centerFragment中
                Intent intent1 = new Intent(RegisterActivity.this,User_centerFragment.class);
                intent1.putExtra("account", account);
                intent1.putExtra("nickname", "未登录");
                setResult(RESULT_OK, intent1);
                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
