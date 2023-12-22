package com.example.hmd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alkohol = findViewById(R.id.alcohol);
        Button weed = findViewById(R.id.weed);
        Button zigaretten = findViewById(R.id.cigarettes);
        Button snus = findViewById(R.id.snus);
        Button overview = findViewById(R.id.overwiev);

        zigaretten.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Cigarettes.class);
            startActivity(nextPage);
        });
        alkohol.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Alcohol.class);
            startActivity(nextPage);
        });
        snus.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Snus.class);
            startActivity(nextPage);
        });
        weed.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Weed.class);
            startActivity(nextPage);
        });
        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(MainActivity.this, Overwiev.class);
                startActivity(nextPage);
            }
        });

    }
}