package com.example.app_huangbowei.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.example.app_huangbowei.User_LoginActivity;
import com.example.app_huangbowei.R;
import com.example.app_huangbowei.User_RegisterActivity;

public class User_centerFragment extends BaseFragment {
    public TextView nicknameTextView;
    private TextView accountTextView;

    private static final int REQUEST_CODE_REGISTER = 1;
    private static final int REQUEST_CODE_LOGIN = 2;

    private final ActivityResultLauncher<Intent> registerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String nickname = "未登录";
                        String account = data.getStringExtra("account");
                        nicknameTextView.setText(nickname);
                        accountTextView.setText(account);
                    }
                }
            });

    private final ActivityResultLauncher<Intent> loginLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String nickname1 = "已登录";
                        String account = data.getStringExtra("account");
                        nicknameTextView.setText(nickname1);
                        accountTextView.setText(account);
                    }
                }
            });

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_user_center;
    }

    public void initView(View rootView) {
        nicknameTextView = rootView.findViewById(R.id.nickname_textview);
        accountTextView = rootView.findViewById(R.id.user_id_textview);
        Button loginButton = rootView.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), User_LoginActivity.class);
                loginLauncher.launch(intent);
            }
        });
        Button registerButton = rootView.findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), User_RegisterActivity.class);
                registerLauncher.launch(intent);
            }
        });
        // 读取SharedPreferences中保存的昵称和账号，如果存在则显示在界面上
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String nickname = sharedPreferences.getString("nickname", "");
        String account = sharedPreferences.getString("account", "");

        if (!TextUtils.isEmpty(nickname)) {
            nicknameTextView.setText(nickname);
        } else {
            nicknameTextView.setText("未登录"); // 显示默认的"未登录"
        }

        if (!TextUtils.isEmpty(account)) {
            accountTextView.setText(account);
        }
    }

    @Override
    public void initData() {
        // 加载数据
    }
}
