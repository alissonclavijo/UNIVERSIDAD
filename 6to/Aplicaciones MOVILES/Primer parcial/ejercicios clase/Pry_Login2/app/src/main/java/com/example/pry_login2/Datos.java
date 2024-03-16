package com.example.pry_login2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Datos extends AppCompatActivity {
    //declaramos objetos
    TextView lblResultado1, lblResultado2;
    Bundle obj1=getIntent().getExtras();

    int fecha=Integer.parseInt(obj1.getString("fecha"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        lblResultado1=findViewById(R.id.txtNombreDato);
        lblResultado2=findViewById(R.id.txtcalDato);

        Bundle datas=this.getIntent().getExtras();

        String name =datas.getString("name");
        String bornDate = datas.getString("born_date");

        lblResultado1.setText("Bienvenido"+name+"\n\n Fecha de Nacimiento:"+bornDate);
    }
}