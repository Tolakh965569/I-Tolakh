package com.dochdonatello.hotelmobileapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dochdonatello.hotelmobileapp.R;
import com.dochdonatello.hotelmobileapp.constant.Constants;
import com.dochdonatello.hotelmobileapp.data.local.UserSharePreference;
import com.dochdonatello.hotelmobileapp.models.User;
import com.dochdonatello.hotelmobileapp.utils.MessageUtils;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername,etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }
    private void initView()
    {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void login()
    {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty())
        {
            MessageUtils.showMessage(this,"Please enter your name.");
        }
        else if(password.isEmpty())
        {
            MessageUtils.showMessage(this,"Please enter your password.");
        }
        else if(!Constants.USER_NAME_DATA.equals(username) || !Constants.USER_PASSWORD_DATA.equals(password))
        {
            MessageUtils.showMessage(this,"Your username and password are incorrect!");
        }
        else
        {
            User user = new User();
            user.setId(1);
            user.setUsername(username);
            user.setPassword(password);
            user.setAccessToken(UUID.randomUUID().toString());
            UserSharePreference.saveUserData(this, user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}