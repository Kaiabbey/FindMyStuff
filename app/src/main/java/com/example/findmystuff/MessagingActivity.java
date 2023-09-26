package com.example.findmystuff;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MessagingActivity extends AppCompatActivity {
    private ImageButton return_button;
    private ImageView emojiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        setViewsIds();

        return_button.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapTrackingActivity.class);
            startActivity(intent);
        });

    }

    private void setViewsIds() {
        return_button = findViewById(R.id.returnButton);
        emojiButton = findViewById(R.id.emoji_button);
    }
}
