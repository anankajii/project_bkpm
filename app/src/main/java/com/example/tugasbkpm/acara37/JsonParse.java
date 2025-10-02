package com.example.tugasbkpm.acara37;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.tugasbkpm.R;

public class JsonParse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara37_json_parse);

        TextView tvJson = findViewById(R.id.tvJson);
        // Contoh JSON lokal
        String jsonString = "{ \"name\": \"Khanan\", \"age\": 20 }";
        tvJson.setText(jsonString);
    }
}
