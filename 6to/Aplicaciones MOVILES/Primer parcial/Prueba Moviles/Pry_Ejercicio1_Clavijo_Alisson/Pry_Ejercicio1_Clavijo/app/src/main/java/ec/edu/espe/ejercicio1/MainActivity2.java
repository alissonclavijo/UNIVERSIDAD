package ec.edu.espe.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btn_regresar;
    TextView lblResult;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_regresar = findViewById(R.id.btn_regresar);
        btn_regresar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // Crear un Intent para iniciar MainActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

                lblResultado.setText(intent.getStringExtra("lblResultado"));

                // Finalizar la actividad actual (MainActivity2)
                finish();

            }

        });
    }
}
