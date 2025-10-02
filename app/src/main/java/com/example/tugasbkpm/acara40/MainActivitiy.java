package com.example.tugasbkpm.acara40;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.example.tugasbkpm.R;
import com.example.tugasbkpm.acara38.JsonApiActivity;
import com.example.tugasbkpm.acara39.MovieDbActivity;
import com.example.tugasbkpm.acara38.JsonParseActivity;


public class MainActivitiy extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara37_activity_layout);
        ImageView showJson = (ImageView) findViewById(R.id.json);
        ImageView showJsonAPI = (ImageView) findViewById(R.id.json_api);
        ImageView showMovieDB = (ImageView) findViewById(R.id.moviedb);

        showJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivitiy.this, JsonApiActivity.class);
                startActivity(intent);
            }
        });
        showJsonAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitiy.this, JsonParseActivity.class);
                startActivity(intent);
            }
        });
        showMovieDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitiy.this, MovieDbActivity.class);
                startActivity(intent);
            }
        });
    }
}
