package com.example.pdy_ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onCreate");

        /*notificaciones*/
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

    }
    /*sobrecarga de metodos*/
    
    @Override
    protected void onStart() {
        super.onStart();
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*ciclo de vida*/
        Log.i("ciclo de vida","Ingresar a onDestroy");
    }
}