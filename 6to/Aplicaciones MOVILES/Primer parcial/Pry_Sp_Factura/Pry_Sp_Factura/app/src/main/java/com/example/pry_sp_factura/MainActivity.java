package com.example.pry_sp_factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText user,password;
Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.et_usuario);
        password=findViewById(R.id.et_contrasenia);
        btn_ingresar=findViewById(R.id.bt_ingresar);

        //botón

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                verificarCredenciales();
        }
        });
    }
    //verificar credenciales
    private void verificarCredenciales() {
        String usuario=user.getText().toString().trim();
        String contrasena= password.getText().toString().trim();

        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contrasena)){
            Toast.makeText(this, "Ingrese el usuario y contraseña", Toast.LENGTH_SHORT).show();

        }else {
            //verificar credenciales predefinidad
            if(usuario.equals("admin") && contrasena.equals("admin")){
                Toast.makeText(this, "¡¡Inicio de sesión Exitoso!!", Toast.LENGTH_SHORT).show();
                //ir a datos de la factura
                Intent intent=new Intent(MainActivity.this, DatosFactura.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }
}