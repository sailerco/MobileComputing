package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {
    HorizontalBarChart barChart;

    HorizontalBarChart barChart_extended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        barChart = findViewById(R.id.barChart_view_1);
        initChart(barChart);
        int[] capacity_percentage = new int[]{70};
        showBarChart(barChart, capacity_percentage);

        barChart_extended = findViewById(R.id.barChart_view_2);
        int[] table_capacity_percentage = new int[]{5, 10, 40};
        initChart(barChart_extended);
        showBarChart(barChart_extended, table_capacity_percentage);
    }
    private void showBarChart(BarChart bar,  int[] list){
        //initBarChart();
        ArrayList<Double> valueList = new ArrayList<Double>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        String title = "Title";
        //input data

        for(int i = 0; i < list.length; i++){
            valueList.add(list[i] * 1.0);
        }
        for (int i = 0; i < valueList.size(); i++){
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(entries, title);
        initBarDataSet(barDataSet);

        BarData data = new BarData(barDataSet);
        //data.setBarWidth(10f);
        bar.setData(data);
        bar.invalidate();
    }
    private void initBarDataSet(BarDataSet barDataSet){
        barDataSet.setColor(Color.parseColor("#FF018786"));
        barDataSet.setDrawValues(false);
    }
    private void initChart(BarChart bar){
        //barChart.setVisibleYRange(0, 100, YAxis.AxisDependency.RIGHT);
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