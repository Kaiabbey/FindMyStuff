package com.example.findmystuff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.findmystuff.activities.SignInActivity;
import com.example.findmystuff.databinding.ActivityChatListBinding;
import com.example.findmystuff.databinding.ActivityDeviceListBinding;
import com.example.findmystuff.utilities.Constants;
import com.example.findmystuff.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class DeviceListActivity extends AppCompatActivity {
    private ActivityDeviceListBinding binding;
    private Button NavigatetoCreateDeviceButton;
    private Button ViewDeviceButton;
    private Button Laptop2Button;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeviceListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        setViewIds();

        binding.LogoutButton.setOnClickListener(v -> signOut());

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

    private void signOut() {
        Toast.makeText(getApplicationContext(), "Signing Out...", Toast.LENGTH_SHORT).show();
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        HashMap<String, Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                    finish();
                })
        .addOnFailureListener(e -> Toast.makeText(getApplicationContext(), "Unable to sign out", Toast.LENGTH_SHORT).show());
    }

    private void setViewIds(){
        ViewDeviceButton = findViewById(R.id.Laptop1ViewButton);
        NavigatetoCreateDeviceButton = findViewById(R.id.CreateDeviceButton);
        Laptop2Button = findViewById(R.id.Laptop2ViewButton);
    }
}