package com.example.laborator4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaMasiniActivity extends AppCompatActivity {

    public static final String CHEIE_LISTA = "listaMasini";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_masini);

        ListView lvMasini = findViewById(R.id.lvMasini);

        // primim lista trimisă din MainActivity
        ArrayList<Masina> lista = getIntent().getParcelableArrayListExtra(CHEIE_LISTA);
        if (lista == null) {
            lista = new ArrayList<>();
        }

        // adapterul apelează toString() pentru fiecare mașină
        ArrayAdapter<Masina> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, lista);
        lvMasini.setAdapter(adapter);
    }
}