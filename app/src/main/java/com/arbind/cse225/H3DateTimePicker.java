package com.arbind.cse225;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class H3DateTimePicker extends AppCompatActivity {
Button timeBtn, dateBtn, alarmBtn;
EditText timeTv, dateTv;
Calendar c;
int day, month, year;
int hh, mm, viewhh;
DatePicker dp;
TimePicker tp;
View dv, tv;
String ampm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h3_date_time_picker);
        dateBtn = findViewById(R.id.button9);
        timeBtn = findViewById(R.id.button10);
        timeTv = findViewById(R.id.editTextTextPersonName3);
        dateTv = findViewById(R.id.editTextTextPersonName2);
        alarmBtn = findViewById(R.id.button11);


        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                day = c.get(Calendar.DATE);
                month = c.get(Calendar.MONTH);
                year = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(H3DateTimePicker.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateTv.setText(""+dayOfMonth+"/"+month+"/"+year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                hh = c.get(Calendar.HOUR_OF_DAY);
                mm = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(H3DateTimePicker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeTv.setText(hourOfDay+":"+minute);
                    }
                },hh,mm, false);
                timePickerDialog.show();


            }
        });
        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(H3DateTimePicker.this, H3Broadcaster.class);
                PendingIntent pi = PendingIntent.getBroadcast(H3DateTimePicker.this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                Toast.makeText(H3DateTimePicker.this, "gonna run soon", Toast.LENGTH_SHORT).show();
            }
        });




    }
}