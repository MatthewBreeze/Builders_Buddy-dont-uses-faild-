package com.example.buildersbuddy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Calender extends AppCompatActivity {

    CalendarView calendarView;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mmm-yyyy",Locale.ENGLISH);


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        calendarView =  findViewById(R.id.calender);

        Event add = new Event() {
            @Override
            public Path getPath() {
                return null;
            }

            @Override
            public void fire() {

            }
        };
    }
}
