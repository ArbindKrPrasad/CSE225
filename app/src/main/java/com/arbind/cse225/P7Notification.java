package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class P7Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7_notification);
    }

    public void canceli(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        PendingIntent pi = PendingIntent.getActivity(this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder nb = new Notification.Builder(this,"CHANNEL_ID");
        nb.setContentTitle("My Notification");
        nb.setContentIntent(pi);
        nb.setContentText("hello pending intent");
        nb.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1,nb.build());

//        try {
//            pi.send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public void createi(View v){

    }
}