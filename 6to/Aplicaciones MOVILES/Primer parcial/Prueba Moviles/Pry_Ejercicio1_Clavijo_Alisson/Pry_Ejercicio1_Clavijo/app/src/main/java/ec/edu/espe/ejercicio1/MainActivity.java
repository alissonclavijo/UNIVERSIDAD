package ec.edu.espe.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaración de variables
    EditText txtVelocidad;
    EditText txtTiempo;
    TextView lblResultado;
    Button btnCalcular;

    //Metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignación de las instancias a los elementos
        txtVelocidad = findViewById(R.id.txtVelocidad);
        txtTiempo = findViewById(R.id.txtTiempo);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblResultado = findViewById(R.id.lblResult);

        // Definición del evento de clic para el botón
        btnCalcular.setOnClickListener(v -> {
            double velocidad = Double.parseDouble(txtVelocidad.getText().toString());
            double tiempo = Double.parseDouble(txtTiempo.getText().toString());
            double resultado = velocidad * tiempo;
            lblResultado.setText(String.valueOf(resultado));
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            intent.putExtra("lblResultado",lblResultado.getText().toString());
        });
    }

        //Metodo calcular
    private void calcular() {

        if (txtVelocidad.getText().toString().isEmpty() || txtTiempo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Ingrese los datos", Toast.LENGTH_SHORT).show();

            return;
        }

        if (!txtVelocidad.getText().toString().matches("[0-9]+") || !txtTiempo.getText().toString().matches("[0-9]+")) {
            Toast.makeText(this, "Ingrese solo números", Toast.LENGTH_SHORT).show();
            return;
        }

        double velocidad = Double.parseDouble(txtVelocidad.getText().toString());
        double tiempo = Double.parseDouble(txtTiempo.getText().toString());
        double resultado = velocidad * tiempo;

        lblResultado.setText(String.valueOf(resultado));

    }


    //Método calcularDistancia
    private double calcularDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }
}