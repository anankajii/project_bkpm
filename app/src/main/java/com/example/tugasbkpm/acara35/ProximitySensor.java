package com.example.tugasbkpm.acara35;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

public class ProximitySensor extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private TextView txtProximity;
    private MediaPlayer mediaPlayer; // untuk audio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara35_proximity);

        txtProximity = findViewById(R.id.txtProximity);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
            txtProximity.setText("Perangkat ini tidak mendukung sensor jarak.");// mp3 kalau tidak support
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        stopAudio();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float value = event.values[0];
        if (value == 0) {
            txtProximity.setText("Dekat");
            playAudio(R.raw.objek_dekat);
        } else {
            txtProximity.setText("Jauh");
            playAudio(R.raw.objek_jauh);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    private void playAudio(int resId) {
        stopAudio();
        mediaPlayer = MediaPlayer.create(this, resId);
        mediaPlayer.start();
    }

    private void stopAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
