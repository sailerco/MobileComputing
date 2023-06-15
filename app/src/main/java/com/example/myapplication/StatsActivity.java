package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class StatsActivity extends AppCompatActivity {
    HorizontalBarChart barChart;

    HorizontalBarChart barChart_extended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        JsonApi json = new JsonApi(editor);
        json.execute();

        barChart = findViewById(R.id.barChart_view_1);
        initChart(barChart);
        showBarChart(barChart, sharedPref, "RoomCapacity_", 1);

        barChart_extended = findViewById(R.id.barChart_view_2);
        initChart(barChart_extended);
        showBarChart(barChart_extended, sharedPref,"TableCapacity_", 3);

        TextView table = findViewById(R.id.stats_fave_table);
        table.setText(sharedPref.getString("FavouriteTable", "Table"));

        Button toHome = findViewById(R.id.button_stats_to_home);
        toHome.setOnClickListener(view -> finish());
    }
    private void showBarChart(BarChart bar, SharedPreferences sharedPref, String name,  int num){
        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "";

        for(int i = 0; i < num; i++){
            int value = sharedPref.getInt(name+i, 0);
            valueList.add(value * 1.0);
        }
        for (int i = 0; i < valueList.size(); i++){
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(entries, title);
        initBarDataSet(barDataSet);

        BarData data = new BarData(barDataSet);
        bar.setData(data);
        bar.invalidate();
    }
    private void initBarDataSet(BarDataSet barDataSet){
        barDataSet.setColor(Color.parseColor("#FF018786"));
        barDataSet.setDrawValues(false);
    }
    private void initChart(BarChart bar){
        bar.setDrawGridBackground(false);
        bar.setDrawBarShadow(false);
        bar.setPinchZoom(false);
        Description description = new Description();
        description.setEnabled(false);
        bar.setDescription(description);
        bar.animateY(1000);
        bar.animateX(1000);

        XAxis xAxis = bar.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setAxisLineWidth(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);

        YAxis yAxisLeft = bar.getAxisLeft();
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setDrawLabels(false);

        YAxis yAxisRight = bar.getAxisRight();
        yAxisRight.setAxisLineWidth(1f);
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setTextSize(12f);
        yAxisRight.setLabelCount(5, true);

        bar.setAutoScaleMinMaxEnabled(false);
        bar.setScaleEnabled(false);
        yAxisRight.setAxisMaximum(100);
        yAxisRight.setAxisMinimum(0);
        yAxisLeft.setAxisMaximum(100);
        yAxisLeft.setAxisMinimum(0);

        bar.getLegend().setEnabled(false);
    }
}