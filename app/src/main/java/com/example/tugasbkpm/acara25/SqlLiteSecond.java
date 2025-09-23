package com.example.tugasbkpm.acara25;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasbkpm.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SqlLiteSecond extends AppCompatActivity {
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara25_sql_lite_second);
        showText = (TextView) findViewById(R.id.gettext);
    }

    public void back(View view) {
        finish();
    }
    public void getPublic(View view) {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "mydata1.txt");
        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("No data");
        }
    }
    public void getPrivate(View view) {
        File folder = getExternalFilesDir("Arsita"); // Folder Name
        File myFile = new File(folder, "mydata2.txt"); // Filename

        String text = getData(myFile);
        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("File is empty");
        }
    }

    private String getData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            StringBuilder buffer = new StringBuilder();
            int i;
            while ((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}