package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String CHEIE_MASINA = "masina";
    private TextView tvMasina;
    private final ArrayList<Masina> listaMasini = new ArrayList<>();
    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle bundle = result.getData().getExtras();
                    Masina masina = bundle.getParcelable(CHEIE_MASINA);
                    if (masina != null) {
                        listaMasini.add(masina);
                        afiseazaLista();
                        Toast.makeText(this, masina.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });

    private void afiseazaLista() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaMasini.size(); i++) {
            sb.append(i + 1).append(". ").append(listaMasini.get(i).toString()).append("\n\n");
        }
        tvMasina.setText(sb.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMasina = findViewById(R.id.tvMasina);
        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnAdaugaAI = findViewById(R.id.btnAdaugaAI);

        btnAdauga.setOnClickListener(v ->
                launcher.launch(new Intent(this, AdaugaMasinaActivity.class)));

        btnAdaugaAI.setOnClickListener(v ->
                launcher.launch(new Intent(this, AdaugaMasinaAIActivity.class)));
    }
}