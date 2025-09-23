package com.example.tugasbkpm.acara21;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;
public class IntentExplicitSecond extends AppCompatActivity {
    TextView txtHello;
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara21_intent_explicit_second);
         txtHello=(TextView) findViewById(R.id.txtHello);
         Bundle extras = getIntent().getExtras();
         nama = extras.getString(KEY_NAME);
         txtHello.setText("Hello, " + nama + " !");
    }
}
