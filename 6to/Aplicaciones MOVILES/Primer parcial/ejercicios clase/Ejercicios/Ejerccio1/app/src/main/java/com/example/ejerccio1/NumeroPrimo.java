package com.example.ejerccio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ejerccio1.ui.main.NumeroPrimoFragment;

public class NumeroPrimo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_primo);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NumeroPrimoFragment.newInstance())
                    .commitNow();
        }
    }
}