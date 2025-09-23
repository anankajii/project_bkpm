package com.example.tugasbkpm;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Recyler15_16 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listKota;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyler15_16);

        adapter = ArrayAdapter.createFromResource(
                this,
                R.array.nama_kota,
                android.R.layout.simple_list_item_1
        );

        listKota = findViewById(R.id.listView);
        listKota.setAdapter(adapter);
        listKota.setOnItemClickListener(this);

        spinner = findViewById(R.id.action_bar_spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Recyler15_16.this,
                        "Spinner pilih: " + adapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        autoCompleteTextView = findViewById(R.id.autoComplete);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(Recyler15_16.this,
                    "AutoComplete pilih: " + adapter.getItem(position),
                    Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ListView pilih: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
