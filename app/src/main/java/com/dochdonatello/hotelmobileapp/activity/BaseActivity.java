package com.dochdonatello.hotelmobileapp.activity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.dochdonatello.hotelmobileapp.data.local.UserSharePreference;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        if(null == UserSharePreference.checkUserLogin(this))
        {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
