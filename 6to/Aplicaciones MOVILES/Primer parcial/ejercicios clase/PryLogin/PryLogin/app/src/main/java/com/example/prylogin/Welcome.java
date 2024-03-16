package com.example.prylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {

    EditText txtName, txtBornDate;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtName = findViewById(R.id.et_name);
        txtBornDate = findViewById(R.id.et_born_date);

        btnCreate = findViewById(R.id.btn_create);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connect = new Intent(Welcome.this, Data.class);
                connect.putExtra("name", txtName.getText().toString());
                connect.putExtra("born_date", txtBornDate.getText().toString());
                startActivity(connect);
            }
        });
    }
}