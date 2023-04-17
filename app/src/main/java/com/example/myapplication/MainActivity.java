package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.button_logIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = (EditText) findViewById(R.id.username_text);
                UserProfile user = new UserProfile(name.getText().toString()); //create User with username
                Intent i = new Intent(MainActivity.this, HomeActivity.class); //creating Intent
                i.putExtra("User", user); //Add User Object to Intent, so it is reachable in HomeActivity
                startActivity(i); //starting the HomeActivity with Intent
            }
        });
    }


}