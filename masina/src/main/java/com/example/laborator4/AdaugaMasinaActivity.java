package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdaugaMasinaActivity extends AppCompatActivity {

    // suprascrisă în AdaugaMasinaAIActivity pentru a folosi alt layout
    protected int getLayoutId() {
        return R.layout.activity_adauga_masina;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        EditText etMarca = findViewById(R.id.etMarca);
        EditText etAn = findViewById(R.id.etAn);
        Spinner spnCombustibil = findViewById(R.id.spnCombustibil);
        RadioGroup rgCaroserie = findViewById(R.id.rgCaroserie);
        CheckBox cbGarantie = findViewById(R.id.cbGarantie);
        CompoundButton swNoua = findViewById(R.id.swNoua); // Switch sau MaterialSwitch
        RatingBar rbRating = findViewById(R.id.rbRating);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.combustibili, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCombustibil.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String marca = etMarca.getText().toString().trim();
            String anText = etAn.getText().toString().trim();

            if (marca.isEmpty() || anText.isEmpty()) {
                Toast.makeText(this, "Completează marca și anul!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton rbSelectat = findViewById(rgCaroserie.getCheckedRadioButtonId());

            Masina masina = new Masina(
                    marca,
                    Integer.parseInt(anText),
                    spnCombustibil.getSelectedItem().toString(),
                    rbSelectat.getText().toString(),
                    cbGarantie.isChecked(),
                    swNoua.isChecked(),
                    rbRating.getRating());

            Bundle bundle = new Bundle();
            bundle.putParcelable(MainActivity.CHEIE_MASINA, masina);

            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}