package ec.edu.prynotificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.timepicker.MaterialTimePicker;

import java.util.Calendar;

import ec.edu.prynotificaciones.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    //Definir clases
    private ActivityMainBinding binding;
    private MaterialTimePicker timePicker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    //program tareas o recordatorios ejecutar en el futuro
    private PendingIntent pendingIntent;
    //es descripcion de una actividad o tareas a realizar a futuro




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //crear un metodo para crear

    private void createNotificationChanel{
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.0){
            CharSequence name="";
            String desc = "Channel for Alarm Manager";
            //creamos una notificacion
            NotificationManager notificationManager=new NotificationChannel("devlopmentApp", name, imp);
            channel.setDescripcion(desc);
            NotificationManager notificationManager1=getSystemService(NotificationManager);
            notificationManager1=createNotificationChanel(channel);
        }
    }
}