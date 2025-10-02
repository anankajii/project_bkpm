package com.example.tugasbkpm.acara35;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

import java.util.List;

public class AllSensor extends AppCompatActivity {

    private TextView txtAllSensor;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara35_all_sensor);

        txtAllSensor = findViewById(R.id.txtAllSensor);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

        if (sensorList.isEmpty()) {
            txtAllSensor.setText("Tidak ada sensor pada perangkat.");
            playAudio(R.raw.all_sensor);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Sensor s : sensorList) {
                sb.append(s.getName()).append("\n");
            }
            txtAllSensor.setText(sb.toString());
            playAudio(R.raw.all_sensor);
        }
    }

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
