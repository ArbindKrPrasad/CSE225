package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class H2ListWithCustomToast extends AppCompatActivity {
ListView lv;
Button submit;
String stateName;
Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h2_list_with_custom_toast);
        lv = findViewById(R.id.listView);
        submit = findViewById(R.id.button5);

        final int imgs[] = { R.drawable.assam, R.drawable.bihar, R.drawable.delhi, R.drawable.gujarat, R.drawable.jk, R.drawable.kerala,
                R.drawable.maharastra, R.drawable.punjab, R.drawable.rajasthan, R.drawable.up};

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.india_states,android.R.layout.simple_list_item_1 );
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stateName = (String) lv.getItemAtPosition(position);

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.h2_resource_file, (ViewGroup) findViewById(R.id.cl));
                ImageView img = layout.findViewById(R.id.imageView3);
                img.setImageResource(imgs[position]);
                TextView tv = layout.findViewById(R.id.textView10);
                tv.setText(stateName);
                toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });

    }
}