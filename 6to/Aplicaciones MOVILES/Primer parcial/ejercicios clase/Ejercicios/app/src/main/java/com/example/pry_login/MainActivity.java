package com.example.pry_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // declarar los objetos graficos
    EditText txtUsuario, txtContrasenia;

    Button btn_login;

    //atributos
    private String user="admin";
    private String password ="admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeo de objetos
        txtUsuario = findViewById(R.id.et_usuario);
        txtContrasenia = findViewById(R.id.et_contrasenia);

        //button
        btn_login = findViewById(R.id.bt_login);

        //metodo onclick

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario, contrasenia;

                //Recibir datos de las cajas de texto
                usuario=txtUsuario.getText().toString();
                contrasenia=txtContrasenia.getText().toString();

                //verificacion Usuario
                if(usuario.length()!=0){
                    if(usuario.equals(user)){
                        //verificacion contrasenia
                        if(contrasenia.length()!=0){
                            if (contrasenia.equals(password)){
                                //Conexion a otra actividad
                                Toast.makeText(MainActivity.this, "Datos Correctos",Toast.LENGTH_SHORT).show();

                                //Llamar clase Intent
                                Intent conec=new Intent(MainActivity.this,Bienvenido.class);
                                startActivity(conec);

                            }else{
                                Toast.makeText(MainActivity.this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "No puedes dar campos Vacios", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No dejes campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}