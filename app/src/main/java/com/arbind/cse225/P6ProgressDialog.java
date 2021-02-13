package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class P6ProgressDialog extends AppCompatActivity {
ProgressDialog progressBar;
int pbstatus = 0;
Handler h = new Handler();
int pbs = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6_progress_dialog);
    }

    public void click(View v){
        progressBar  = new ProgressDialog(v.getContext());
        progressBar.setIcon(R.drawable.ic_launcher_background);
        progressBar.setCancelable(true);
        progressBar.setMessage("file getting downloaded");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();
        pbs = progressBar.getProgress();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(pbs<100){
                    pbs++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(pbs);
                        }
                    });
                }
            }
        });
        t.start();
    }
}