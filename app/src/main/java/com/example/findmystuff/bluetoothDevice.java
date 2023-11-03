package com.example.findmystuff;

import java.io.Serializable;

public class bluetoothDevice implements Serializable {
    private String name;
    private String deviceType;
    private String deviceID;
    private String userID;

    public bluetoothDevice(String name, String deviceType, String deviceID, String userID){
        this.name = name;
        this.deviceType = deviceType;
        this.deviceID = deviceID;
        this.userID = userID;
    }

    public  bluetoothDevice(String name, String deviceID){
        this.name = name;
        this.deviceID = deviceID;
    }
    public String getDeviceID() {
        return deviceID;
    }
    public String getUserID() {
        return userID;
    }
    public String getName() {
        return name;
    }
    public String getDeviceType() {
        return deviceType;
    }
}
