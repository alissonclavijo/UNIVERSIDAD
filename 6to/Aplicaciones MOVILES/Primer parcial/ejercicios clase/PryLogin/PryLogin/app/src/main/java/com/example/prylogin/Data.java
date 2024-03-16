package com.example.prylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Data extends AppCompatActivity {

    TextView lblName, lblBornDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        lblName = findViewById(R.id.txt_name);
        lblBornDate = findViewById(R.id.txt_born_date);

        Bundle datas = this.getIntent().getExtras();

        String name = datas.getString("name");
        String bornDate = datas.getString("born_date");

        lblName.setText("Bienvenido " + name + "\n\nFecha de Nacimiento: " + bornDate);
        lblBornDate.setText(calculateAge(bornDate));
    }

    private String calculateAge(String bornDate) {
        String[] arrDate = bornDate.split("/");
        int bornYear = Integer.parseInt(arrDate[0]);
        int bornMonth = Integer.parseInt(arrDate[1]);
        int bornDay = Integer.parseInt(arrDate[2]);

        Date date = new Date();
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDay();

        if (day < bornDay){
            month--;
            day+=31;
        }

        if (month < bornMonth){
            year--;
            month+=12;
        }

        int calcAge = year - bornYear;
        int calcMonth = month - bornMonth;
        int calcDay = day - bornDay;

        return "Edad: " + calcAge + " años\n" + calcMonth + " meses\n" + calcDay + " dias\n";
    }
}