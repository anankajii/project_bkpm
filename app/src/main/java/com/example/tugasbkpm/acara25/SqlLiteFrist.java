package com.example.tugasbkpm.acara25;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class SqlLiteFrist extends AppCompatActivity {
    EditText editText;
    private final int STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara25_sql_lite_frist);

        editText = findViewById(R.id.editText2);
    }
    public void next(View view) {
        Intent intent = new Intent(SqlLiteFrist.this, SqlLiteSecond.class);
        startActivity(intent);
    }
    public void savePublic(View view) {
        String info = editText.getText().toString();
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "mydata1.txt");
        writeData(myFile, info);
        editText.setText("");
    }
    public void savePrivate(View view) {
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("Arsita");
        File myFile = new File(folder, "mydata2.txt");
        writeData(myFile, info);
        editText.setText("");
    }
    private void writeData(File myFile, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done: " + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error writing file", Toast.LENGTH_SHORT).show();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
