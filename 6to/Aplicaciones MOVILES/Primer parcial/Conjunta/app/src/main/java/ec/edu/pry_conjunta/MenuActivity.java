package ec.edu.pry_conjunta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private Usuario usuario;
    private TextView txtvNombreUsuario;
    private Button btnMantenimiento;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        usuario = (Usuario)getIntent().getSerializableExtra("usuario");
        txtvNombreUsuario = findViewById(R.id.txtvNombreUsuario);
        btnMantenimiento = findViewById(R.id.btnMantenimiento);
        txtvNombreUsuario.setText(usuario.getNick());
        btnSalir = findViewById(R.id.btnSalir);

        btnMantenimiento.setOnClickListener(l -> {
            irAMantenimiento();
        });

        btnSalir.setOnClickListener(l -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void irAMantenimiento() {
        Intent intent = new Intent(this, MenuMantenimiento.class);
        startActivity(intent);
    }
}