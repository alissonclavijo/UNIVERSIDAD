package com.example.ejerccio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Declarar objetos
    EditText txtIngresarMoneda;
    EditText IngreseNumeroPrimo1;
    TextView lblResultadoMoneda;
    TextView numero_primo1;
    Button btnConvertMoneda;
    Button bt_conexion;
    Button btn_Primo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Mapeo objetos
        txtIngresarMoneda = findViewById(R.id.et_ingreso_monedas);
        lblResultadoMoneda = findViewById(R.id.tv_mostrar_moneda);
        btnConvertMoneda = findViewById(R.id.bt_convertir);
        IngreseNumeroPrimo1 = findViewById(R.id.IngreseNumeroPrimo);
        numero_primo1 = findViewById(R.id.numero_primo);
        btn_Primo1 = findViewById(R.id.btn_Primo);
        bt_conexion = findViewById(R.id.bt_conexion);

        // Programar el proceso
        btnConvertMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Declarar variables
                String euros = txtIngresarMoneda.getText().toString();
                // Convertir tipo de dato
                Double euro = Double.parseDouble(euros);
                // Proceso conversion
                Double dolares = euro * 1.09;

                // Imprimir
                String dolar = String.valueOf(dolares);
                lblResultadoMoneda.setText(dolar);
            }
        });

        btn_Primo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén el número ingresado como texto desde el EditText
                String numeroIngresadoStr = IngreseNumeroPrimo1.getText().toString();

                // Verifica si el campo no está vacío
                if (!numeroIngresadoStr.isEmpty()) {
                    // Convierte el número ingresado a un entero
                    int numeroIngresado = Integer.parseInt(numeroIngresadoStr);

                    // Verifica si el número ingresado es primo
                    if (esPrimo(numeroIngresado)) {
                        // El número es primo
                        numero_primo1.setText("Es un número primo");
                    } else {
                        // El número no es primo
                        numero_primo1.setText("No es un número primo");
                    }
                } else {
                    // El campo está vacío, muestra un mensaje de error
                    numero_primo1.setText("Por favor, ingrese un número");
                }
            }
        });

        // Conectar pantalla dos
        bt_conexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NumeroPrimo.class);
                startActivity(intent);
            }
        });
    }

    // Función para verificar si un número es primo
    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
