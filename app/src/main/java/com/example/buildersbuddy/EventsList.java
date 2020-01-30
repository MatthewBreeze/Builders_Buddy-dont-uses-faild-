package com.example.buildersbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsList extends AppCompatActivity {

    FirebaseAuth Auth;
    DatabaseReference mDatabase;
    ListView ListView;
    ArrayList<String>  List;
    ArrayAdapter<String> adapter;
    Events cEevents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
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
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for(DataSnapshot ds: dataSnapshot.getChildren()) {

                    cEevents = ds.getValue(Events.class);
                    List.add(cEevents.getDate()+cEevents.getLocation()+cEevents.getTime()+cEevents.getDate());
                }
                ListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

    }
}

