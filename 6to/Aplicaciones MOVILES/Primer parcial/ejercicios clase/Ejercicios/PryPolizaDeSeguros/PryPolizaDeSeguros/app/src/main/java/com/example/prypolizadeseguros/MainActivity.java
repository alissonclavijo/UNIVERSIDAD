package com.example.prypolizadeseguros;

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
    EditText txtNombre, txtAlquiler, txtAccidentes, txtCostoTotal,TxtCostoTotalNombre;
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
        TxtCostoTotalNombre = findViewById(R.id.txtTotalPolizaNombre);

        btnNuevo = findViewById(R.id.btnNuevo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalir = findViewById(R.id.btnSalir);

        rdgModelos = findViewById(R.id.rg_modelo);
        rdgEdad = findViewById(R.id.rg_edad);

        rdbModeloA = findViewById(R.id.rb_modeloA);
        rdbModeloB = findViewById(R.id.rb_modeloB);
        rdbModeloC = findViewById(R.id.rb_modeloC);

        rdbMin = findViewById(R.id.rb_edad_min);
        rdbMedia = findViewById(R.id.rb_edad_med);
        rdbMaximo = findViewById(R.id.rb_edad_max);
    }

    //metodo
    public void calcular(View view){
        //proceso
        double valor, accid, costopoliza, cargoxvalor, cargoxedad, cargoxaccid, cargoaccibasico=0, cargoxmodelo;
        //cargo por valor
        valor=Double.parseDouble(txtAlquiler.getText().toString());
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

         //costo por accidente
        if(accid>=0 && accid<=3){
            cargoaccibasico=17*accid;
            cargoxaccid=cargoaccibasico;
        }else{
            cargoxaccid=cargoaccibasico+((accid*21)-63);
        }
        //costo toal del valor de la poliza
        costopoliza=cargoxvalor+cargoxmodelo+cargoxedad+cargoxaccid;
        //imprimir
         txtCostoTotal.setText(String.valueOf(costopoliza));

        TxtCostoTotalNombre.setText(txtNombre.getText().toString());
    }
    //metodo nuevo
    public void nuevo(View view){
        txtNombre.setText("");
        txtAlquiler.setText("");
        txtAccidentes.setText("");
        txtCostoTotal.setText("");
        TxtCostoTotalNombre.setText("");

        rdbMin.setChecked(false);
        rdbMaximo.setChecked(false);
        rdbMedia.setChecked(false);
        rdbModeloA.setChecked(false);
        rdbModeloB.setChecked(false);
        rdbModeloC.setChecked(false);

        txtNombre.requestFocus();
    }
    //metodo salir
    public void salir(View view){
        finish();
    }


}