package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class P11Battery extends AppCompatActivity {
    TextView tv;
    P11Receiver b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p11_battery);
        tv = findViewById(R.id.textView11);
        b = new P11Receiver(tv);
        registerReceiver(b, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}