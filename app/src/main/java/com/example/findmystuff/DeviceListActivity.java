package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class DeviceListActivity extends AppCompatActivity {

    private Button NavigatetoCreateDeviceButton;
    private Button ViewDeviceButton;
    private Button Laptop2Button;
    private Button LogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        setViewIds();

        LogoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        ViewDeviceButton.setOnClickListener(view -> {
            //Change to chaz's monitoring Activity
            Intent intent = new Intent(this, Device_Info.class);
            startActivity(intent);
        });

        NavigatetoCreateDeviceButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateDeviceActivity.class);
            startActivity(intent);
        });

        Laptop2Button.setOnClickListener(view -> {
            Toast.makeText(DeviceListActivity.this, "Test Button!",Toast.LENGTH_SHORT).show();
        });
    }

    private void setViewIds(){
        LogoutButton = findViewById(R.id.LogoutButton);
        ViewDeviceButton = findViewById(R.id.Laptop1ViewButton);
        NavigatetoCreateDeviceButton = findViewById(R.id.CreateDeviceButton);
        Laptop2Button = findViewById(R.id.Laptop2ViewButton);
    }
}