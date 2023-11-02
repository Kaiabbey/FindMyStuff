package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Task_Manager extends AppCompatActivity {
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_manager);
        setViewsIds();
        returnButton.setOnClickListener(view -> {
            Intent intent=new Intent(this,Device_Info.class);
            startActivity(intent);
        });
    }
    private void setViewsIds(){
        returnButton = findViewById(R.id.return_button);
    }
}