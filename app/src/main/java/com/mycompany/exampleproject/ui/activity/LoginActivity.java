package com.mycompany.exampleproject.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mycompany.exampleproject.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout edtLogin, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
    }

    private void bindViews() {
        edtLogin = findViewById(R.id.edt_login);
        edtPassword = findViewById(R.id.edt_password);
    }
}
