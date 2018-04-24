package com.example.akshay.practicalquiz1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    SharedPreferences s;
    TextView nameTV,emailTV,writeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        nameTV = findViewById(R.id.tv1);
        emailTV = findViewById(R.id.tv2);
        writeTV = findViewById(R.id.tv3);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

         s = getSharedPreferences("myFile", Context.MODE_PRIVATE);
        String name = s.getString("name","Key doesn’t match");
        String email= s.getString("email","Key doesn’t match");
        String write= s.getString("write","Key doesn’t match");

        nameTV.setText(name);
        emailTV.setText(email);
        writeTV.setText(write);



    }
}
