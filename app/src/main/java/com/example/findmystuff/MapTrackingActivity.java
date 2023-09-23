package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MapTrackingActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_tracking);

        View bottomSheet = findViewById(R.id.bottom_sheet_tracking);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }
}
