package com.mycompany.exampleproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.mycompany.exampleproject.R;
import com.mycompany.exampleproject.data.request.UserLoginResponse;
import com.mycompany.exampleproject.viewmodel.LoginViewModel;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edtLogin, edtPassword;
    private Button btnLogin;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        bindViews();
        setupListeners();
        setupObservers();
    }

    private void setupListeners() {
        btnLogin.setOnClickListener(v -> {
            String login = Objects.requireNonNull(edtLogin.getText()).toString();
            String password = Objects.requireNonNull(edtPassword.getText()).toString();
            loginViewModel.doLogin(login, password);
        });
    }

    private void setupObservers() {
        loginViewModel.login.observe(this, userLoginResponse -> {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra(HomeActivity.EXTRA_USER, userLoginResponse);
            startActivity(intent);
        });
    }

    private void bindViews() {
        edtLogin = findViewById(R.id.edt_login);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}
