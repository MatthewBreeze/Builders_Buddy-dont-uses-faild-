package com.example.buildersbuddy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Calender extends AppCompatActivity {

    FirebaseAuth  Auth;

// ...
    DatabaseReference mDatabase;
    CalendarView calendarView;
    EditText Event, location;
    Button saveevent;
    Events events;
    Button save;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mmm-yyyy",Locale.ENGLISH);
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);
        Auth = FirebaseAuth.getInstance();
        if(Auth.getCurrentUser()== null)
        {
            startActivity(new Intent(getApplicationContext(),Sign_In.class));
            finish();
        }
        calendarView =  findViewById(R.id.calendar);
        Event = findViewById(R.id.event);
        location = findViewById(R.id.location);
        saveevent = findViewById(R.id.save);
        events = new Events();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
    }
    public void save(View view)
    {
                String id = Auth.getUid().trim();
                calendarView.getDate();
                String event = Event.getText().toString().trim();
                String date ;

                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
                {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
                    {
                       String date = i2 + "/" + (i1 + 1 ) +"/" + i;
                       Toast.makeText(Calender.this, "you have set a event for "+ date ,Toast.LENGTH_LONG).show();
                       events.setDate(date);
                    }
                });
                if(TextUtils.isEmpty(event))
                {
                    Event.setError("you must enter a event");
                }
                String elocation = location.getText().toString().trim();

                if(TextUtils.isEmpty(elocation))
                {
                    location.setError("you must set a location");
                }
                events.setId(id);
                events.setEvent(event);
                events.setLocation(elocation);
                mDatabase.push().setValue(events);

    }

    public void View(View view)
    {
        startActivity(new Intent(getApplicationContext(), EventsList.class));
        finish();
    }
}

