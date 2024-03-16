package ec.edu.pry_factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaramos variables
    EditText txtusuario, txtcontrasena;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusuario = findViewById(R.id.usuario);
        txtcontrasena = findViewById(R.id.contrasena);
        btnIngresar = findViewById(R.id.btnIngresar);

        // configurar el OnClickListener para el botón
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCredenciales();
            }
        });
    }

    private void verificarCredenciales() {
        String usuario = txtusuario.getText().toString().trim();
        String contrasena = txtcontrasena.getText().toString().trim();

        // verificación
        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contrasena)) {
            Toast.makeText(this, "Por favor ingrese Usuario y Contraseña", Toast.LENGTH_SHORT).show();
        } else {
            // verificar credenciales predefinidas
            if (usuario.equals("admin") && contrasena.equals("admin")) {
                Toast.makeText(this, "Ingreso Exitoso", Toast.LENGTH_SHORT).show();
                // ir a datos de factura

               startActivity(new Intent(MainActivity.this, DatosFactura.class));
            } else {
                Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
