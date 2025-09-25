package com.example.tugasbkpm.acara35;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAllSensor, btnLightSensor, btnProximitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara35_activity_main);

        btnAllSensor = findViewById(R.id.btnAllSensor);
        btnLightSensor = findViewById(R.id.btnLightSensor);
        btnProximitySensor = findViewById(R.id.btnProximitySensor);

        btnAllSensor.setOnClickListener(this);
        btnLightSensor.setOnClickListener(this);
        btnProximitySensor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnAllSensor) {
            startActivity(new Intent(this, AllSensor.class));
        } else if (id == R.id.btnLightSensor) {
            startActivity(new Intent(this, LightSensor.class));
        } else if (id == R.id.btnProximitySensor) {
            startActivity(new Intent(this, ProximitySensor.class));
        }
    }


}
