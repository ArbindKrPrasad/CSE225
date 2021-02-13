package com.arbind.cse225;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

public class P1Toolbar extends AppCompatActivity {
ArrayAdapter a;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_toolbar);
        Toolbar tv = findViewById(R.id.toolBar);
        setSupportActionBar(tv);

        lv = findViewById(R.id.listView);

        String fruits[] = {"mango", "apple", "papaya"};
        a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits);
        lv.setAdapter(a);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView sv = (SearchView) search.getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                a.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}