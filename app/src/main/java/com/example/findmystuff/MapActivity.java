package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MapActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheet;
    private Button trackingDevice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        setViewsIds();

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        trackingDevice1.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapTrackingActivity.class);
            startActivity(intent);
        });
    }

    private void setViewsIds() {
        bottomSheet = findViewById(R.id.bottom_sheet_map);
        trackingDevice1 =findViewById(R.id.tracking_device_1);
    }
}
