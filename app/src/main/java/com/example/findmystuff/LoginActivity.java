package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import com.example.findmystuff.DBConnection;

import java.util.concurrent.CompletableFuture;

public class LoginActivity extends AppCompatActivity {

    private Button  loginButton;
    private Button  registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setViewIds();

        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, DeviceListActivity.class);
            startActivity(intent);
        });

        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void setViewIds(){
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
    }
}