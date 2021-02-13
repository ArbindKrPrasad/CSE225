package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class P2RatingBar extends AppCompatActivity {
RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_rating_bar);
    }

    public void fetchRating(View v){
        rb = findViewById(R.id.ratingBar);
        float rat =  rb.getRating();

        Toast.makeText(this, "The rating is "+rat, Toast.LENGTH_SHORT).show();
    }
}