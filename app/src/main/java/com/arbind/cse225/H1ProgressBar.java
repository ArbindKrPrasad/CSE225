package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class H1ProgressBar extends AppCompatActivity {
ProgressBar pb;
TextView tv;
int progressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h1_progress_bar);

        pb = findViewById(R.id.progressBar2);
        tv = findViewById(R.id.textView6);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100){
                    progressStatus++;
                    pb.setProgress(progressStatus);
                    tv.setText(progressStatus+"/"+pb.getMax());
                    try{
                        Thread.sleep(50);
                    }
                    catch(InterruptedException e){

                    }
                }

                Intent i = new Intent(getApplicationContext(), H1SubmitSuccessful.class);
                startActivity(i);


            }
        });
        t.start();
    }
}