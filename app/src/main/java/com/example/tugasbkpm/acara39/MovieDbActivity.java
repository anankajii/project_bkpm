package com.example.tugasbkpm.acara39;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tugasbkpm.R;
import androidx.fragment.app.FragmentManager;

public class MovieDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara39_moviedb);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new FragmentMovie())
                    .commit();
        }
    }
}