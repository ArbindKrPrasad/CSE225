package com.arbind.cse225;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class P11Receiver extends BroadcastReceiver {
    TextView tv;
    P11Receiver(TextView v){
        tv = v;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int p = intent.getIntExtra("level", 0);
        Toast.makeText(context, "Hello "+p+"%", Toast.LENGTH_SHORT).show();
        if(p<20){
            Toast.makeText(context, "Battery is lower than 20%.Please connect to Charger", Toast.LENGTH_SHORT).show();
        }
    }
}
