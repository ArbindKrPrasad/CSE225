package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class P3ProgressBar extends AppCompatActivity {
ProgressBar pb;
int progressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_progress_bar);
        pb = findViewById(R.id.pb);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100){
                    progressStatus += 1;
                    pb.setProgress(progressStatus);
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e){

                    }
                }
            }
        }); t.start();

    }
}