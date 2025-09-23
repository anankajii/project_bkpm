package com.example.tugasbkpm.acara31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugasbkpm.R;
import com.example.tugasbkpm.acara31.Preference;

public class RegisterActivity extends AppCompatActivity {

    private EditText etEmailSignup, etPasswordSignup, etPasswordSignup2;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara31_register_activity);
        etEmailSignup = findViewById(R.id.et_emailSignup);
        etPasswordSignup = findViewById(R.id.et_passwordSignup);
        etPasswordSignup2 = findViewById(R.id.et_passwordSignup2);
        buttonSignUp = findViewById(R.id.button_signUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etEmailSignup.getText().toString().trim();
                String password = etPasswordSignup.getText().toString().trim();
                String confirmPassword = etPasswordSignup2.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Harap isi semua field", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Password tidak sama", Toast.LENGTH_SHORT).show();
                } else {
                    Preference.setRegisteredUser(getBaseContext(), username);
                    Preference.setRegisteredPass(getBaseContext(), password);
                    Toast.makeText(RegisterActivity.this, "Registrasi berhasil! Silakan login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
