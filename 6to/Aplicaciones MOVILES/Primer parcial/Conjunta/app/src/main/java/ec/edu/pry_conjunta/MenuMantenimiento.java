package ec.edu.pry_conjunta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MenuMantenimiento extends AppCompatActivity {
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_mantenimiento);

        Toast.makeText(this, "Ingresado A noticias", Toast.LENGTH_SHORT).show();

        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(l -> {
            regresar();
        });
    }

    private void regresar() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}