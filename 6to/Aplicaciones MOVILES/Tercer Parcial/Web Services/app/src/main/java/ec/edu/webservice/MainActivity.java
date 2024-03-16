package ec.edu.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText txtCodigo;
    EditText txtProducto;
    EditText txtPrecio;
    EditText txtFabricante;

    Button btnAgregar, btnBuscar, btnEliminar, btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        txtCodigo=findViewById(R.id.et_codigo);
        txtProducto=findViewById(R.id.et_producto);
        txtPrecio=findViewById(R.id.et_precio);
        txtFabricante=findViewById(R.id.et_fabrica);
        btnAgregar=findViewById(R.id.bt_agregar);
        btnAgregar=findViewById(R.id.bt_agregar);
        btnBuscar=findViewById(R.id.bt_buscar);
        btnEliminar=findViewById(R.id.bt_eliminar);
        btnEditar=findViewById(R.id.bt_editar);


        //
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamar metodo ejecutar

                ejecutarServicio("http://10.40.11.28:80/tienda/insertar_producto.php");

            }
        });

        //
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamar metodo ejecutar

                ejecutarServicio("http://10.40.11.28:80/tienda/buscar_producto.php");

            }
        });

        //
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamar metodo ejecutar

                ejecutarServicio("http://10.40.11.28:80/tienda/eliminar_producto.php");

            }
        });

        //
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamar metodo ejecutar

                ejecutarServicio("http://10.40.11.28:80/tienda/insertar_producto.php");

            }
        });

    }



    //para ejecutar servicio
    private void ejecutarServicio(String URL){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_LONG).show();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }

            //
        }) {
            @Override
            protected  Map<String, String> getParams() {
                Map<String, String> parametros=new HashMap<String, String>();
                parametros.put("codigo",txtCodigo.getText().toString());
                parametros.put("producto",txtProducto.getText().toString());
                parametros.put("precio",txtPrecio.getText().toString());
                parametros.put("fabricante",txtFabricante.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
}