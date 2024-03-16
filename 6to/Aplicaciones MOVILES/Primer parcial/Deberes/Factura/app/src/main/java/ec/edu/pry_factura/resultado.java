package ec.edu.pry_factura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    TextView lblCantidad, lblPrecio, lblTotal, lblSubtotal, lbliva, lblDetalle,lblMarca,  lblTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            String tipo= extras.getString("tipo");
            String marca= extras.getString("marca");
            String precio= extras.getString("precio");
            String cantidad= extras.getString("cantidad");

            String subtotal= extras.getString("subtotal");
            String iva= extras.getString("iva");
            String total= extras.getString("total");




            //referencias
            lblCantidad=findViewById(R.id.lblCantidad);
            lblMarca=findViewById(R.id.lblMarca);
            lblTipo=findViewById(R.id.lbltipo);
            lblPrecio=findViewById(R.id.lblPrecio);
            lbliva=findViewById(R.id.lbliva);
            lblTotal =findViewById(R.id.lblTotal);
            lblSubtotal = findViewById(R.id.lblSubtotal);

            //establecer valores en la caja de texto
            lblTipo.setText(tipo);
            lblMarca.setText(marca);
            lblPrecio.setText(precio);
            lblCantidad.setText(cantidad);
            lblSubtotal.setText(subtotal);
            lbliva.setText(iva);
            lblTotal.setText(total);


        }
    }
}