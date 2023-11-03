package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

public class DeviceListActivity extends AppCompatActivity {

    ArrayList<bluetoothDevice> deviceList;
    private RecyclerView recyclerView;
    private bluetoothDeviceAdapter bdeviceAdapter;
    private Button NavigatetoCreateDeviceButton;
    private Button LogoutButton;
    private Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);
        setViewIds();
        adapterInit();

        CompletableFuture.runAsync(() -> {
            DBConnection DBconnection = new DBConnection();
            String[] bIDArray = DBconnection.getDeviceIDs("1");
            for (int i=0; i < bIDArray.length; i++){
                System.out.println(i);
                Map<String,String> BDevice = DBconnection.getDevice(bIDArray[i]);
                deviceList.add(new bluetoothDevice(BDevice.get("name"),BDevice.get("bluetoothID")));
            }

        });

        LogoutButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        NavigatetoCreateDeviceButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateDeviceActivity.class);
            startActivity(intent);
        });

        refreshButton.setOnClickListener(view ->{
            bdeviceAdapter.notifyDataSetChanged();
        });

    }

    void adapterInit(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        deviceList = new ArrayList<>();
        bdeviceAdapter = new bluetoothDeviceAdapter(deviceList);
        recyclerView.setAdapter(bdeviceAdapter);
    }

    private void setViewIds(){
        refreshButton = findViewById(R.id.refreshButton);
        recyclerView = findViewById(R.id.recyclerView);
        LogoutButton = findViewById(R.id.LogoutButton);
        NavigatetoCreateDeviceButton = findViewById(R.id.CreateDeviceButton);
    }



}