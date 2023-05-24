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

public class LoginActivity extends AppCompatActivity {

    private EditText accountEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        accountEditText = findViewById(R.id.account_edittext);
        passwordEditText = findViewById(R.id.password_edittext);

        Button loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // 校验账号和密码是否正确
                if (checkAccountAndPassword(account, password)) {
                    // 更新昵称信息到SharedPreferences中
                    SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nickname", "已登录"); // 设置昵称为"已登录"
                    editor.apply();

                    // 返回状态和账号到User_centerFragment中
                    Intent intent = new Intent(LoginActivity.this, User_centerFragment.class);
                    intent.putExtra("account", account);
                    intent.putExtra("nickname", "已登录");
                    setResult(RESULT_OK, intent);
                    Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码错误，请重新输入！", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean checkAccountAndPassword(String account, String password) {
        // 从SharedPreferences中读取账号和密码信息
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String correctPassword = sharedPreferences.getString("password", "");
        String correctAccount = sharedPreferences.getString("account", "");
        return account.equals(correctAccount) && password.equals(correctPassword);
    }
}
