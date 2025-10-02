package com.example.tugasbkpm.acara41;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest; // Ganti StringRequest ke JsonObjectRequest
import com.android.volley.toolbox.Volley;
import com.example.tugasbkpm.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddUser extends AppCompatActivity {

    EditText edtRegEmail, edtRegPass, edtRegConfirmPass;
    Button btnRegisterAction;
    TextView txtBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara41_register);

        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPass = findViewById(R.id.edtRegPass);
        edtRegConfirmPass = findViewById(R.id.edtRegConfirmPass);
        btnRegisterAction = findViewById(R.id.btnRegisterAction);
        txtBackLogin = findViewById(R.id.txtBackLogin);

        btnRegisterAction.setOnClickListener(v -> actionRegister());
        txtBackLogin.setOnClickListener(v -> {
            startActivity(new Intent(AddUser.this, LoginActivity.class));
            finish();
        });
    }

    private void actionRegister() {
        String email = edtRegEmail.getText().toString().trim();
        String pass = edtRegPass.getText().toString().trim();
        String confirmPass = edtRegConfirmPass.getText().toString().trim();

        Log.d("REGISTER", "Tombol diklik, input: " + email);

        if (email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            Toast.makeText(this, "Isi semua field!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pass.equals(confirmPass)) {
            Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("REGISTER", "Mulai kirim ke server...");

        // Gunakan JsonObjectRequest untuk handle JSON response
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiConfig.URL_REGISTER, null,
                response -> {
                    Log.d("REGISTER", "Response: " + response.toString());
                    try {
                        boolean success = response.getBoolean("success");
                        String message = response.getString("message");

                        Toast.makeText(AddUser.this, message, Toast.LENGTH_SHORT).show();

                        if (success) {
                            startActivity(new Intent(AddUser.this, LoginActivity.class));
                            finish();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(AddUser.this, "JSON Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },
                error -> {
                    Log.e("REGISTER", "Volley Error: " + error.toString());
                    Toast.makeText(AddUser.this, "Koneksi Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json"); // Sesuaikan dengan API
                headers.put("Accept", "application/json");
                return headers;
            }

            @Override
            public byte[] getBody() {
                try {
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("email", email);
                    jsonBody.put("password", pass);
                    return jsonBody.toString().getBytes("utf-8");
                } catch (Exception e) {
                    return null;
                }
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

        Log.d("REGISTER", "Request ditambahkan ke queue");
    }
}