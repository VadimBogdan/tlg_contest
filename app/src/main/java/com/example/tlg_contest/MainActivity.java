package com.example.tlg_contest;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.tlg_contest.data.ChartsLoader;
import com.example.tlg_contest.domain.Chart;
import com.example.tlg_contest.widget.ChartView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Chart chart;

    private int toX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_main);

        final ChartView chartView = findViewById(R.id.chart_view);
        chartView.setDirection(-1);

        // TODO: Find a better format
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM d", Locale.US);

        ChartsLoader.loadCharts(getApplicationContext(), (List<Chart> charts) -> {
            chart = charts.get(0);
            toX = chart.x.length - 1 - 92;
            chartView.setChart(chart, dateFormatter::format);
        });

        Handler handler = new Handler();

        Runnable action = new Runnable() {
            @Override
            public void run() {
                toX -= 1;
                if (toX > 0) {
                    chartView.setRange(0, toX, true);
                    chartView.snap(true);
                    handler.postDelayed(this, 1250L);
                }
            }
        };

        handler.postDelayed(action, 1000L);
    }
}