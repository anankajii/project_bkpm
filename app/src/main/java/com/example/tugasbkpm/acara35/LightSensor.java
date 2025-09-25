package com.example.tugasbkpm.acara35;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

public class LightSensor extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView txtLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara35_light_sensor);

        txtLight = findViewById(R.id.txtLight);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (lightSensor == null) {
            txtLight.setText("Light Sensor tidak tersedia");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        txtLight.setText("Intensitas Cahaya: " + event.values[0] + " lux");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}
