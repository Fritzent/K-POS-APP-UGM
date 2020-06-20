package com.example.k_pos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.k_pos.R;

import java.util.ArrayList;

public class OpenStoreScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    OpenStoreRxAdapter openStoreRxAdapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_store_screen);

        //this to hide the default actionbar from android studio
        getSupportActionBar().hide();

        //this is to implementation the xml component to java
        recyclerView = findViewById(R.id.RecycleItemStoreLocation);

        items = new ArrayList<>();
        items.add("First CardView Item");
        items.add("Second CardView Item");
        items.add("Third CardView Item");
        items.add("Four CardView Item");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        openStoreRxAdapter = new OpenStoreRxAdapter(this,items);
        recyclerView.setAdapter(openStoreRxAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
