package com.zfizet.weighttracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
// mikephil package used for LineChart in application
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Main dashboard that displays current date, chart, and allows editing weights.
 */

public class DashboardActivity extends AppCompatActivity {
    TextView dateText;
    Button editGoalWeightButton, enterDailyWeightButton;
    LineChart weightChart;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Get username passed from login

        username = getIntent().getStringExtra("username");

        // Initialize UI components

        dateText = findViewById(R.id.date);
        editGoalWeightButton = findViewById(R.id.editGoalWeight);
        enterDailyWeightButton = findViewById(R.id.enterDailyWeight);
        weightChart = findViewById(R.id.weightChart);

        // Display current date

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
        dateText.setText(sdf.format(new Date()));

        editGoalWeightButton.setOnClickListener(v -> {
            // Launch dialog or new activity to input/edit goal weight
        });

        enterDailyWeightButton.setOnClickListener(v -> {
            // Launch dialog or new activity to input/edit daily weight
        });

        displayWeightChart();
    }

    private void displayWeightChart() {
        List<Entry> entries = new ArrayList<>();

        // Dummy data for now
        entries.add(new Entry(1, 240));
        entries.add(new Entry(2, 237));
        entries.add(new Entry(3, 235));
        entries.add(new Entry(4, 233));

        LineDataSet dataSet = new LineDataSet(entries, "Weight Over Time");
        dataSet.setColor(getResources().getColor(R.color.purple_700));
        dataSet.setValueTextColor(getResources().getColor(R.color.black));
        LineData lineData = new LineData(dataSet);

        weightChart.setData(lineData);
        weightChart.getDescription().setEnabled(false);
        weightChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        weightChart.invalidate();
    }
}

