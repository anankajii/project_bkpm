package com.example.tugasbkpm.acara37;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.tugasbkpm.R;

public class MovieDb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara37_movie_db);

        TextView tvMovie = findViewById(R.id.tvMovie);
        // Contoh menampilkan data MovieDB
        tvMovie.setText("Data MovieDB akan muncul di sini.");
    }
}
