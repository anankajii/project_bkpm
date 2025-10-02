package com.example.tugasbkpm.acara36;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

import java.util.ArrayList;
import java.util.List;

public class AllSensorActivity extends AppCompatActivity {

    private ListView listViewSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara36_activity_all_sensor);

        listViewSensors = findViewById(R.id.listViewSensors);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        List<String> sensorNames = new ArrayList<>();
        for (Sensor s : sensorList) {
            sensorNames.add(s.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, sensorNames);
        listViewSensors.setAdapter(adapter);
    }
}
