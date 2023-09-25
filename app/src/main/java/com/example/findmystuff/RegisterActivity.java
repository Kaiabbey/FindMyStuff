package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button backButton;
    private Button createNewAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setViewIds();

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        createNewAccountButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            Toast.makeText(RegisterActivity.this, "Account Created!",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }

    private void setViewIds(){
        backButton = findViewById(R.id.BackButton);
        createNewAccountButton = findViewById(R.id.CreateAccountButton);
    }
}