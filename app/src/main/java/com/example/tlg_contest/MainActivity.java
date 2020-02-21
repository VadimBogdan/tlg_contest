package com.example.tlg_contest;

import android.os.Bundle;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_main);

        final ChartView chartView = findViewById(R.id.chart_view);
        // TODO: Find a better format
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM d", Locale.US);

        ChartsLoader.loadCharts(getApplicationContext(),
                (List<Chart> charts) -> chartView.setChart(charts.get(0), dateFormatter::format));
    }
}
