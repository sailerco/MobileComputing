package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        UserProfile user = (UserProfile) getIntent().getSerializableExtra("User");
        TextView welcome_txt = (TextView) findViewById(R.id.user_home_screen);
        welcome_txt.append(" "+ user.username + " (" + user.project + ", " + user.percent_contract + "%)");

        Button book = (Button) findViewById(R.id.button_book);
        Button open = (Button) findViewById(R.id.button_open);
        Button stats = (Button) findViewById(R.id.button_stats);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CalenderActivity.class));
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OpenDeskActivity.class));
            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, StatsActivity.class));
            }
        });
    }
}