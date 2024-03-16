package com.example.pry_login2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    //declaramos
    TextView txtNombre,txtFecha;
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        txtNombre = findViewById(R.id.txtNombre);


    }
}