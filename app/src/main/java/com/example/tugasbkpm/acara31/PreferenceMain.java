package com.example.tugasbkpm.acara31;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

public class PreferenceMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (!Preference.getLoggedInStatus(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.acara31_main_activity);

        TextView nama = findViewById(R.id.tv_namaMain);
        nama.setText(Preference.getLoggedInUser(getBaseContext()));

        findViewById(R.id.button_logoutMain).setOnClickListener((v) -> {
            Preference.clearLoggedInUser(getBaseContext());
            startActivity(new Intent(getBaseContext(), LoginActivity.class));
            finish();
        });
    }
}
