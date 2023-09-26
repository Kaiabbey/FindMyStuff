package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MapTrackingActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private View bottomSheet;
    private ImageView callMessage;
    private TextView callText;
    private imageView return_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_tracking);

        setViewsIds();

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        callMessage.setOnClickListener(view -> {
            Intent intent = new Intent(MapTrackingActivity.this, MessagingActivity.class);
            startActivity(intent);
        });

        callText.setOnClickListener(view -> {
            Intent intent = new Intent(MapTrackingActivity.this, MessagingActivity.class);
            startActivity(intent);
        });

        return_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        });
    }

    private void setViewsIds() {
        bottomSheet = findViewById(R.id.bottom_sheet_tracking);
        callMessage = findViewById(R.id.call_message);
        callText = findViewById(R.id.call_text);
        return_button = findViewById(R.id.returnButton);
    }
}
