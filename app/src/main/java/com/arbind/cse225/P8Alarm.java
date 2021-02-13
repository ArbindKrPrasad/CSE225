package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class P8Alarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_alarm);
    }
    public void alarm(View v){
        EditText et = findViewById(R.id.editTextNumber);
        int i = Integer.parseInt(et.getText().toString());
        Intent intent  = new Intent(this, P8Mybroadcast.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000), pi);
        Toast.makeText(this, "alarm will ring in "+i+"seconds", Toast.LENGTH_SHORT).show();
    }
}