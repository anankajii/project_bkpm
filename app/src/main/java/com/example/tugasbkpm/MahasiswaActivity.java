package com.example.tugasbkpm;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaActivity extends androidx.appcompat.app.AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa>mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receyler15);
        addData();

        recyclerView =findViewById(R.id.receylerview);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    void addData(){
        mahasiswaArrayList= new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Dimas maulana", "1414370309", "123456789"));
        mahasiswaArrayList.add(new Mahasiswa("Fadly Yonk", "1214230345", "987648765"));
        mahasiswaArrayList.add(new Mahasiswa("Ariyandi Nugraha", "1214230345", "987648765"));
        mahasiswaArrayList.add(new Mahasiswa("Aham Siswana", "1214378098", "098758124"));



    }
}
