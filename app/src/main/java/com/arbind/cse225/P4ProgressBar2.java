package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class P4ProgressBar2 extends AppCompatActivity {
Button pause, stop;
ProgressBar pb;
boolean isPause = false;
Handler h = new Handler();
Thread t;
TextView tvv1;
    int progressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_progress_bar2);
        pause = findViewById(R.id.button);
        stop = findViewById(R.id.button2);

        pb = findViewById(R.id.progressBar);
        tvv1 = findViewById(R.id.textView);
        pause.setText("pause");

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100){
                    progressStatus += 1;
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setProgress(progressStatus);
                            tvv1.setText(progressStatus+"/"+ pb.getMax());
                        }
                    });
                    pb.setProgress(progressStatus);
                    try{
                        Thread.sleep(50);
                    }
                    catch(InterruptedException e){

                    }
                }
            }
        });
        t.start();

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPause==true){
                    t.start();
                    pause.setText("resume");
                    isPause = false;
                }
                else{
                    pause.setText("pause");
                    try {
                        t.sleep(1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isPause = true;
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;

            }
        });
    }
}