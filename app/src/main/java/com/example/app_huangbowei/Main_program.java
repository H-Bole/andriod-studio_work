package com.example.app_huangbowei;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;


import com.example.app_huangbowei.fragment.Smart_tourismFragment;
import com.example.app_huangbowei.fragment.Home_pageFragment;
import com.example.app_huangbowei.fragment.User_centerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//主程序页

public class Main_program extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian_program);
        getSupportActionBar().hide();

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        FragmentContainerView fragmentContainerView = findViewById(R.id.fragment_container_view);

        bottomNavView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.menu_home_page:
                    selectedFragment = new Home_pageFragment();
                    break;
                case R.id.menu_smart_tourism:
                    selectedFragment = new Smart_tourismFragment();
                    break;
                case R.id.menu_user_center:
                    selectedFragment = new User_centerFragment();
                    break;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(fragmentContainerView.getId(), selectedFragment)
                        .commit();
            }

            return true;
        });

        bottomNavView.setSelectedItemId(R.id.menu_home_page);
    }
}
