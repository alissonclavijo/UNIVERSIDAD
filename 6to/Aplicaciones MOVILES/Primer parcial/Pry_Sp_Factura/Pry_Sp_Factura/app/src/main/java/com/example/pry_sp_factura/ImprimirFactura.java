package com.example.pry_sp_factura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImprimirFactura extends AppCompatActivity {
    TextView lblRcantidad, lblRPrecio, lblRTotal, lblRSubTotal, lblRIva, lblRTipo, lblRMarca;

    Button boton;

    final static int REQUEST_CODE = 1233;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_factura);
        boton = findViewById(R.id.boton);

        askPermissions();

        /*Bundle*/
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tipo = extras.getString("tipo");
            String marca = extras.getString("marca");
            String cantidad = extras.getString("cantidad");
            String precio = extras.getString("precio");
            String subtotal = extras.getString("subtotal");
            String iva = extras.getString("iva");
            String total = extras.getString("total");

            /*Referencias*/

            lblRcantidad = findViewById(R.id.tv_r_cantidad);
            lblRPrecio = findViewById(R.id.tv_r_preciou);
            lblRMarca = findViewById(R.id.tv_r_marca);
            lblRTipo = findViewById(R.id.tv_r_tipo);
            lblRSubTotal = findViewById(R.id.tv_r_preciot);
            lblRIva = findViewById(R.id.tv_r_iva);
            lblRTotal = findViewById(R.id.tv_r_totalp);


            /*Establecer valores en la caja de texto*/
            lblRTipo.setText(tipo);
            lblRMarca.setText(marca);
            lblRcantidad.setText(cantidad);
            lblRPrecio.setText(precio);
            lblRSubTotal.setText(subtotal);
            lblRIva.setText(iva);
            lblRTotal.setText(total);
            askPermissions();
        }


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertXMLtoPDF();
            }
        });

    }


    private void askPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
    }

    private void convertXMLtoPDF() {

        View view = LayoutInflater.from(this).inflate(R.layout.activity_imprimir_factura, null);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.getDisplay().getRealMetrics(displayMetrics);
        } else
            this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.EXACTLY));
        Log.d("mylog", "Width Now " + view.getMeasuredWidth());
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);

        PdfDocument document = new PdfDocument();

        int viewWidth = 1080;
        int viewHeight = 1920;

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(viewWidth, viewHeight, 1).create();

        // Start a new page
        PdfDocument.Page page = document.startPage(pageInfo);

        // Get the Canvas object to draw on the page
        Canvas canvas = page.getCanvas();

        // Create a Paint object for styling the view
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        // Draw the view on the canvas
        view.draw(canvas);

        // Finish the page
        document.finishPage(page);

        // Specify the path and filename of the output PDF file
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String fileName = "factura1.pdf";
        File filePath = new File(downloadsDir, fileName);

        try {
            FileOutputStream fos = new FileOutputStream(filePath, false);
            document.writeTo(fos);
            document.close();
            fos.close();
            // PDF conversion successful
            Toast.makeText(this, "Factura guardada", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}