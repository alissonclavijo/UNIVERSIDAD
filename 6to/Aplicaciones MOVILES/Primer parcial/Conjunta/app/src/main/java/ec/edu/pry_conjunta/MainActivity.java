package ec.edu.pry_conjunta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String USUARIO = "admin";
    private final String PASSWORD = "admin";

    private EditText edtUsuario;
    private EditText edtPassword;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // asignamos las variables a los controles graficos
        edtUsuario = findViewById(R.id.usuario);
        edtPassword = findViewById(R.id.password);
        btnInicio = findViewById(R.id.btnInicio);

        // capturamos el evento cuando se hace click en el boton inicio
        btnInicio.setOnClickListener(l -> {
            loguearse();
        });
    }

    private void loguearse() {
        String usuarioStr = edtUsuario.getText().toString();
        String passwordStr = edtPassword.getText().toString();

        if (!usuarioStr.equalsIgnoreCase(USUARIO)) {
            // mostrar un mensaje de error si el usuario no coincide
            Toast.makeText(this, "El usuario coincide", Toast.LENGTH_SHORT).show();
        }

        if (!passwordStr.equals(PASSWORD)) {
            // mostrar un mensaje si la contraseña no coincide
            Toast.makeText(this, "La contraseña  coincide", Toast.LENGTH_SHORT).show();
        }

        Usuario usuario = new Usuario(usuarioStr, passwordStr);
        Intent intent = new Intent(this, MenuActivity.class);

        // enviar a la ventana de menu
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }
}