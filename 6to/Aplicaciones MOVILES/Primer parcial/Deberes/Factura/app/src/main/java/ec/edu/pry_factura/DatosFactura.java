package ec.edu.pry_factura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DatosFactura extends AppCompatActivity {
    //variables
    EditText txtPrecio,txtCantidad;
    Button btnCompra;
    Spinner spTipo, spMarca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_factura);
        //Mapeo
        spTipo=findViewById(R.id.spTipo);
        spMarca= findViewById(R.id.spMarca);
        txtPrecio=findViewById(R.id.txtPrecio);
        txtCantidad=findViewById(R.id.txtCantidad);
        btnCompra=findViewById(R.id.btnCompra);

        //definir el combo Box
        Spinner spinner=findViewById(R.id.spTipo);
        String opcionSleccionada=spinner.getSelectedItem().toString();

        Spinner spinner1 =findViewById(R.id.spMarca);
        String opcionSleccionadaMarca=spinner1.getSelectedItem().toString();


        //metodo comprar
        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtener datos seleccionados del spinner
                String tipoSeleccionado=spTipo.getSelectedItem().toString();
                String marcaSeleccionada=spMarca.getTransitionName().toString();

                //datos de edit text
                String precio=txtPrecio.getText().toString();
                String cantidad=txtCantidad.getText().toString();

                //cacular el iva y total
                double precioUnitario=Double.parseDouble(precio);
                int cantidad1=Integer.parseInt(cantidad);

                double subtotal=precioUnitario*cantidad1;
                double iva=subtotal*0.12;

                double total=subtotal+iva;


                //pasa los datos a la 3era pantalla Inprimir factura
                Intent intent=new Intent(DatosFactura.this, resultado.class);

                //pasar datos
                intent.putExtra("tipo",tipoSeleccionado);
                intent.putExtra("marca",marcaSeleccionada);
                intent.putExtra("precio",precioUnitario);
                intent.putExtra("cantidad",cantidad);

                intent.putExtra("subtotal",String.valueOf(subtotal));
                intent.putExtra("iva",String.valueOf(iva));
                intent.putExtra("total",String.valueOf(total));

                startActivity(intent);
            }
        });

    }
}