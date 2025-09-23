package com.example.tugasbkpm;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;

public class RecylerView extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView listView;
ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receyler_view);

        ListView listView = findViewById(R.id.listView);
        adapter = ArrayAdapter.createFromResource(this,R.array.countries_arry, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this::onItemClick);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
