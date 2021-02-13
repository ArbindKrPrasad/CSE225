package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class P10TimePicker extends AppCompatActivity {
TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10_time_picker);
        tp = findViewById(R.id.timePicker2);
        tp.setIs24HourView(false);

    }
    public void time(View v){
        int hr = tp.getHour();
        int min = tp.getMinute();
        int ampm = tp.getBaseline();
        Toast.makeText(this, hr+" "+min, Toast.LENGTH_SHORT).show();
    }
}