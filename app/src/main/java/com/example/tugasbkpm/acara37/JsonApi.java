package com.example.tugasbkpm.acara37;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.tugasbkpm.R;

public class JsonApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara37_json_api);

        TextView tvApi = findViewById(R.id.tvApi);
        // Contoh menampilkan data API
        tvApi.setText("Data JSON dari API akan muncul di sini.");
    }
}
