package com.example.buildersbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

<<<<<<< HEAD:app/src/main/java/com/example/buildersbuddy/Events/EventsList.java
import com.example.buildersbuddy.Home_Page;
import com.example.buildersbuddy.R;
import com.example.buildersbuddy.TradsCard.TradeCards;
import com.google.firebase.FirebaseApp;
=======
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting:app/src/main/java/com/example/buildersbuddy/EventsList.java
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsList extends AppCompatActivity {


    FirebaseAuth Auth;
    DatabaseReference mDatabase;
    ListView ListView;
    Events events;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
<<<<<<< HEAD:app/src/main/java/com/example/buildersbuddy/Events/EventsList.java
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        events = new Events();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView = (ListView) findViewById(R.id.ListView);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                startActivity(new Intent(getApplicationContext(), Event.class)
                        .putExtra("date",events.getDate())
                        .putExtra("location",events.getLocation())
                        .putExtra("time", events.getTime())
                        .putExtra("event",events.getEvent()));

            }
        });


        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
=======
        Auth = FirebaseAuth.getInstance();
        if(Auth.getCurrentUser()== null)
        {
            startActivity(new Intent(getApplicationContext(),Sign_In.class));
            finish();
        }

        cEevents = new Events();
        List = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.event_info,R.id.ListView, List);
        ListView.setAdapter(adapter);
        mDatabase.addValueEventListener(new ValueEventListener() {
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting:app/src/main/java/com/example/buildersbuddy/EventsList.java
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {

                    events = ds.getValue(Events.class);
                    //if(events.getId() == Auth.getUid())
                   // {
                        arrayList.add(events.getDate() + "     |     "+ events.getLocation()+"     |      "+events.getEvent());
                  //  }
                }
                ListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

    public void Back(View view)
    {
        startActivity(new Intent(getApplicationContext(), Calender.class));
        finish();
    }

}