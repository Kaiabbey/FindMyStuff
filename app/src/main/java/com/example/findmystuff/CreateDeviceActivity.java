package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class CreateDeviceActivity extends AppCompatActivity {
    private Button backButton;
    private Button createDeviceButton;
    private Button testConnectionButton;
    private RadioButton dongleRadio;
    private RadioButton computerRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_device);
         setViewIds();
        testConnectionButton.setOnClickListener(view -> {
            Toast.makeText(CreateDeviceActivity.this, "Functionality not implemented :(",Toast.LENGTH_SHORT).show();
        });

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, DeviceListActivity.class);
            startActivity(intent);
        });

        createDeviceButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, DeviceListActivity.class);
            Toast.makeText(CreateDeviceActivity.this, "Device Created!",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        computerRadio.setOnClickListener(view ->{
            Toast.makeText(CreateDeviceActivity.this, "COMPUTER!",Toast.LENGTH_LONG).show();
        });

        dongleRadio.setOnClickListener(view ->{
            Toast.makeText(CreateDeviceActivity.this, "DONGLE!",Toast.LENGTH_LONG).show();
        });
    }

    private void setViewIds(){
        backButton = findViewById(R.id.BackButton);
        createDeviceButton = findViewById(R.id.CreateDeviceButton);
        testConnectionButton = findViewById(R.id.TestConnectionButton);
        computerRadio = findViewById(R.id.radio_computer);
        dongleRadio = findViewById(R.id.radio_dongle);
    }
}