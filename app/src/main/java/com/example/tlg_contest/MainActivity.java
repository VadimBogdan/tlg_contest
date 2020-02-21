package com.example.tlg_contest;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.tlg_contest.data.ChartsLoader;
import com.example.tlg_contest.domain.Chart;
import com.example.tlg_contest.widget.ChartFinderView;
import com.example.tlg_contest.widget.ChartView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_main);

        // TODO: Find a better format
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM d", Locale.US);

        final ChartView chartView = findViewById(R.id.chart_view);
        final ChartFinderView chartFinderView = findViewById(R.id.chart_finder_view);

        chartView.setDirection(-1);
        chartView.setLabelCreator(dateFormatter::format);

        chartFinderView.attachTo(chartView);

        ChartsLoader.loadCharts(getApplicationContext(),
                (List<Chart> charts) -> chartFinderView.setChart(charts.get(0)));
    }
}