package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class OpenDeskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seating);
        List<Button> btnList = new ArrayList<Button>();
        btnList.add(findViewById(R.id.button_seat_nr1));
        btnList.add(findViewById(R.id.button_seat_nr2));
        btnList.add(findViewById(R.id.button_seat_nr3));
        btnList.add(findViewById(R.id.button_seat_nr4));
        btnList.add(findViewById(R.id.button_seat_nr5));
        btnList.add(findViewById(R.id.button_seat_nr6));
        btnList.add(findViewById(R.id.button_seat_nr7));
        btnList.add(findViewById(R.id.button_seat_nr8));
        btnList.add(findViewById(R.id.button_seat_nr9));
        btnList.add(findViewById(R.id.button_seat_nr10));

        btnList.forEach(btn -> {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OpenDeskActivity.this, BookingViewActivity.class));
                }
            });
        } );
    }
}