
package com.example.marinescu_maria_sofia_activitatedam2026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitateRezultat extends AppCompatActivity {

    private int nr1;
    private int nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_rezultat);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String mesaj = bundle.getString("mesaj", "");
            nr1 = bundle.getInt("nr1", 0);
            nr2 = bundle.getInt("nr2", 0);

            Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show();
        }
    }

    public void intoarceInActivitate(View view) {
        int suma = nr1 + nr2;

        Intent rezultat = new Intent();
        rezultat.putExtra("altMesaj", "Mesaj nou");
        rezultat.putExtra("suma", suma);

        setResult(RESULT_OK, rezultat);
        finish();
    }
}
