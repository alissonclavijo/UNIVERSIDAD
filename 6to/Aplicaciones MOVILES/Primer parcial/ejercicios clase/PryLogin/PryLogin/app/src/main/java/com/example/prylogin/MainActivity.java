package com.example.prylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Graphic objects
    EditText txtUser, txtPassword;
    Button btnLogin;

    private String user="Admin";
    private String password="Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Map objects
        //Texts
        txtUser = findViewById(R.id.et_user);
        txtPassword = findViewById(R.id.et_password);
        //Buttons
        btnLogin = findViewById(R.id.btn_login);

        //OnClick login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString(), password = txtPassword.getText().toString();

                if (checks(user, password)){
                    //Message
                    Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    //Activity Welcome
                    Intent connect = new Intent(MainActivity.this, Welcome.class);
                    startActivity(connect);
                }

            }
        });
    }

    private boolean checks(String user, String password){
        if (user.isEmpty()){
            Toast.makeText(MainActivity.this, "Usuario no ingresado", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()){
            Toast.makeText(MainActivity.this, "Contraseña no ingresada", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(checkUser(user) && checkPassword(password))){
            Toast.makeText(MainActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean checkUser(String user){
        if (user.length() == 0)
            return false;

        return this.user.equals(user);
    }

    private boolean checkPassword(String password){
        if (password.length() == 0)
            return false;

        return this.password.equals(password);
    }
}