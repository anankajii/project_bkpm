package com.example.tugasbkpm.acara41;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

public class MainActivity extends AppCompatActivity {

    TextView tvUserName;
    Button btnLogout, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara41_main);

        // Inisialisasi semua view
        tvUserName = findViewById(R.id.tvUserName);
        btnLogout = findViewById(R.id.btnLogout);
        btnProfile = findViewById(R.id.btnProfile);  // ✅ Aktifkan ini

        // Ambil data dari Intent
        String fullname = getIntent().getStringExtra("fullname");
        String email = getIntent().getStringExtra("email");

        // Set text - hanya tampilkan email di tvUserName
        tvUserName.setText("Email: " + email);  // ✅ Perbaiki ini

        // Logout button
        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        // Profile button
        btnProfile.setOnClickListener(v -> {
            // bisa diarahkan ke halaman profil lain
        });
    }
}