package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class SeatingActivity extends AppCompatActivity{

    //TODO: Add Logic if it is already reserved or not
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
                    switch (view.getId()){
                        case R.id.button_seat_nr1:
                        case R.id.button_seat_nr4:
                        case R.id.button_seat_nr3:
                        case R.id.button_seat_nr7:
                        case R.id.button_seat_nr8:
                        case R.id.button_seat_nr9:
                        case R.id.button_seat_nr10:
                            startActivity(new Intent(SeatingActivity.this, SeatingCompActivity.class));
                            break;
                        case R.id.button_seat_nr2:
                        case R.id.button_seat_nr5:
                        case R.id.button_seat_nr6:
                            startActivity(new Intent(SeatingActivity.this, UserRequestActivity.class));
                            break;
                    }
                }
            });
        } );
    }
}