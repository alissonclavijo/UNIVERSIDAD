package com.example.pry_sp_factura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ipsec.ike.SaProposal;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class DatosFactura extends AppCompatActivity {

    EditText txtPrecio;
    EditText txtCantidad;
    Spinner cboTipoCa;
    Spinner cboMarca;
    Button btnComprar;
    ImageView imvProducto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_factura);
        txtPrecio = findViewById(R.id.et_precio);
        txtCantidad = findViewById(R.id.et_cantidad);
        cboMarca = findViewById(R.id.sp_marca);
        cboTipoCa = findViewById(R.id.sp_tipo);
        btnComprar = findViewById(R.id.bt_comprar);
        imvProducto = findViewById(R.id.imv_Producto);

        //definir el spinner//
        Spinner spinner=findViewById(R.id.sp_tipo);
        String opcionSeleccionada=spinner.getSelectedItem().toString();

        Spinner spinner1=findViewById(R.id.sp_marca);
        String opcionSeleccionada1=spinner.getSelectedItem().toString();
        //metodo comprar//

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //obtener datos seleccionados del spinner//
                String tipoSeleccionado= cboTipoCa.getSelectedItem().toString();
                String marcaSeleccionada= cboMarca.getSelectedItem().toString();

                //Datos de editText
                String cantidad=txtCantidad.getText().toString();
                String precio=txtPrecio.getText().toString();

                //Calcular iva y total

                double precioUnitario=Double.parseDouble(precio);
                int cantidadZ=Integer.parseInt(cantidad);

                double subTotal=precioUnitario*cantidadZ;
                double iva=subTotal*0.12;
                double total=subTotal+iva;

                //pasar datos a la pantalla de Imprimir
                Intent obj1=new Intent(DatosFactura.this,ImprimirFactura.class);
                //pasar datos
                obj1.putExtra("tipo",tipoSeleccionado);
                obj1.putExtra("marca",marcaSeleccionada);
                obj1.putExtra("cantidad",cantidad);
                obj1.putExtra("precio",precio);
                obj1.putExtra("Subtotal",String.valueOf(subTotal));
                obj1.putExtra("iva",String.valueOf(iva));
                obj1.putExtra("Total", String.valueOf(total));
                /*Iniciar la actividad*/
                startActivity(obj1);




            }
        });
    }
}