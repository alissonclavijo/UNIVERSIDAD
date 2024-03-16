package com.example.pryejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables graficas
    EditText txtNombre, txtAlquiler, txtAccidentes, txtCostoTotal;
    Button btnNuevo, btnCalcular, btnSalir;
    RadioGroup rdgModelos, rdgEdad;
    RadioButton rdbModeloA, rdbModeloB, rdbModeloC, rdbMin, rdbMedia, rdbMaximo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mapeo de variables
        txtNombre = findViewById(R.id.txtNombre);
        txtAlquiler = findViewById(R.id.txtValor);
        txtAccidentes = findViewById(R.id.txtNAccidentes);
        txtCostoTotal = findViewById(R.id.txtTotalPoliza);

        btnNuevo = findViewById(R.id.btnNuevo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalir = findViewById(R.id.btnSalir);

        rdgModelos = findViewById(R.id.rg_modelo);
        rdgEdad = findViewById(R.id.rg_edad);

        rdbModeloA = findViewById(R.id.rb_modeloA);
        rdbModeloB = findViewById(R.id.rb_ModeloB);
        rdbModeloC = findViewById(R.id.rb_ModeloC);

        rdbMin = findViewById(R.id.rb_min);
        rdbMedia = findViewById(R.id.rb_edad_med);
        rdbMaximo = findViewById(R.id.rb_edad_max);
    }

    //metodo
    public void calcular(View view){
        //proceso
        double valor, accid, costopoliza, cargoxvalor, cargoxedad, cargoxaccid, cargoaccibasico=0, cargoxmodelo;
        //cargo por valor
        valor=Double.parseDouble(txtCostoTotal.getText().toString());
        accid=Double.parseDouble(txtAccidentes.getText().toString());
        cargoxvalor=valor*0.35;

        //Proceso
        if(rdbModeloA.isChecked()){
            cargoxmodelo=valor*0.011;
        }else if(rdbModeloB.isChecked()){
            cargoxmodelo=valor*0.012;
        }else if(rdbModeloC.isChecked()){
            cargoxmodelo=valor*0.15;
        }else{
            cargoxmodelo=0;
        }

        //cargo por edad
        if(rdbMin.isChecked()){
            cargoxedad=360;
        } else if(rdbMedia.isChecked()){
            cargoxedad=240;
        } else if(rdbMin.isChecked()){
            cargoxedad=430;
        }else{
            cargoxedad=0;
        }
    }
}