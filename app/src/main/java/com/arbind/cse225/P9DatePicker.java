package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class P9DatePicker extends AppCompatActivity {
DatePickerDialog dp;
Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_date_picker);


    }

    public void submit(View v){
        c = Calendar.getInstance();
        int day = c.get(Calendar.MONTH);
        int month = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        //Toast.makeText(this, ""+day+" "+month+" "+year+" ", Toast.LENGTH_SHORT).show();

        dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(P9DatePicker.this, ""+dayOfMonth+" "+month+" "+year, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

//        dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                Toast.makeText(P9DatePicker.this, ""+dayOfMonth+" "+month+" "+year, Toast.LENGTH_SHORT).show();
//            }
//        }, year, month, day);

    }
}