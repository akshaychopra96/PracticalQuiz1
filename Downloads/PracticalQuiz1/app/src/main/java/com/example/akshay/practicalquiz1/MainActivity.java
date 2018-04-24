package com.example.akshay.practicalquiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar mTopToolbar;

    EditText name,email,write;
    Button nextButton;
    SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        name = findViewById(R.id.usernameEditText);
        email = findViewById(R.id.emailEditText);
        write = findViewById(R.id.writeEditText);

        nextButton = findViewById(R.id.button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = getSharedPreferences("myFile", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = s.edit();
                e.putString("name",name.getText().toString());
                e.putString("email",email.getText().toString());
                e.putString("write",write.getText().toString());
                e.commit();

            }
        });

        if(savedInstanceState != null){
            name.setText(savedInstanceState.getString("name"));
            email.setText(savedInstanceState.getString("email"));
            write.setText(savedInstanceState.getString("write"));
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.nextActivity:
                Intent i  = new Intent(this,DetailsActivity.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("name",name.getText().toString());
        outState.putString("email",email.getText().toString());
        outState.putString("write",write.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
