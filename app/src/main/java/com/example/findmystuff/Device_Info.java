package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Device_Info extends AppCompatActivity {
private Button batteryButton;
private Button mapButton;
private Button tasksButton;
private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        setViewsIds();
        batteryButton.setOnClickListener(view -> {
            Intent intent=new Intent(this,Battery_Info.class);
            startActivity(intent);
        });
        mapButton.setOnClickListener(view -> {
            Intent intent=new Intent(this,MapActivity.class);
            startActivity(intent);
        });
        tasksButton.setOnClickListener(view -> {
            Intent intent=new Intent(this,Task_Manager.class);
            startActivity(intent);
        });
        returnButton.setOnClickListener(view -> {
            Intent intent=new Intent(this,DeviceListActivity.class);
            startActivity(intent);
        });
    }
    private void setViewsIds(){
        batteryButton = findViewById(R.id.battery_button);
        mapButton = findViewById(R.id.map_button);
        tasksButton = findViewById(R.id.tasks_button);
        returnButton = findViewById(R.id.return_button);

    }
}