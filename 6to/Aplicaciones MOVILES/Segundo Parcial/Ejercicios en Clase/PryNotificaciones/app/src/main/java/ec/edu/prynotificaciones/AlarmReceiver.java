package ec.edu.prynotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AlarmReceiver extends BroadcastReceiver {
    @SuppressLint("MissingPermission")
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent nexActivity =new Intent(context, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,nexActivity,0);

        //configurar y mostrar una notificacion
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "DevelopmentApp")
                .setSmallIcon(R.drawable.baseline_notifications_active_24)
                .setContentTitle("Remider")
                .setContentText("Its time to wake up")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setDefaults(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);
    }


}