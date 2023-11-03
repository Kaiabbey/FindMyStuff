package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.TextView;

import java.util.concurrent.CompletableFuture;

public class CreateDeviceActivity extends AppCompatActivity {
    private Button backButton;
    private Button createDeviceButton;
    private Button testConnectionButton;
    private RadioButton dongleRadio;
    private RadioButton computerRadio;
    private TextView deviceName;
    private TextView bluetoothID;
    private RadioGroup radioGroup;
    private String radioValue = "";
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
            bluetoothID.setBackgroundResource(0);
            deviceName.setBackgroundResource(0);
            radioGroup.setBackgroundResource(0);
            if(deviceName.getText().toString().equals("")){
                deviceName.setBackgroundResource(R.drawable.border);
                return;
            }
            if(radioValue == ""){
                radioGroup.setBackgroundResource(R.drawable.border);
                return;
            }
            if(bluetoothID.getText().toString().equals("")){
                bluetoothID.setBackgroundResource(R.drawable.border);
                return;
            }

            System.out.println(radioGroup.getCheckedRadioButtonId());

            DBConnection dbConnection = new DBConnection();
            CompletableFuture.runAsync(() -> {
                dbConnection.AddDevice(deviceName.getText().toString(),1, radioValue,bluetoothID.getText().toString());
            });

            Intent intent = new Intent(this, DeviceListActivity.class);
            Toast.makeText(CreateDeviceActivity.this, deviceName.getText()+ " Created!" ,Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

        computerRadio.setOnClickListener(view ->{
            Toast.makeText(CreateDeviceActivity.this, "COMPUTER!",Toast.LENGTH_LONG).show();
            radioValue = "computer";
        });

        dongleRadio.setOnClickListener(view ->{
            Toast.makeText(CreateDeviceActivity.this, "DONGLE!",Toast.LENGTH_LONG).show();
            radioValue = "dongle";
        });
    }

    private void setViewIds(){
        radioGroup = findViewById(R.id.RadioGroup);
        backButton = findViewById(R.id.BackButton);
        createDeviceButton = findViewById(R.id.CreateDeviceButton);
        testConnectionButton = findViewById(R.id.TestConnectionButton);
        computerRadio = findViewById(R.id.radio_computer);
        dongleRadio = findViewById(R.id.radio_dongle);
        deviceName = findViewById(R.id.deviceNameText);
        bluetoothID = findViewById(R.id.bluetoothIDText);
    }
}