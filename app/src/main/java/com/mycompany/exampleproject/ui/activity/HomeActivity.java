package com.mycompany.exampleproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mycompany.exampleproject.R;

public class HomeActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "EXTRA_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
