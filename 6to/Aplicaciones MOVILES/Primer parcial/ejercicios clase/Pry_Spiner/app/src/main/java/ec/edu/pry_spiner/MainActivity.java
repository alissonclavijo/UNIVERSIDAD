package ec.edu.pry_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // declaración de variables
    Spinner cboDatos;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // mapeo
        cboDatos = findViewById(R.id.sp_datos);
        lblResultado = findViewById(R.id.tv_resultados);
        // evento
        cboDatos.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // seleccionar el item y mostrar en el textView
        String item = adapterView.getItemAtPosition(i).toString();
        lblResultado.setText(item);

        // Mostrar un Toast con el mensaje seleccionado
        Toast.makeText(MainActivity.this, "Seleccionaste: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // mostramos vacío
        lblResultado.setText("");
    }
}
