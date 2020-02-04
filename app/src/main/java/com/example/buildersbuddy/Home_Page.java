package com.example.buildersbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.example.buildersbuddy.Events.Calender;
import com.example.buildersbuddy.TradsCard.TradeCards;
import com.example.buildersbuddy.tax.TaxPage;
=======
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting
=======
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting
=======
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting
=======
>>>>>>> parent of c0006e8... Layout and pages. code needs implemeting
import com.google.firebase.auth.FirebaseAuth;

public class Home_Page extends AppCompatActivity {
    FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

        Auth = FirebaseAuth.getInstance();
        if(Auth.getCurrentUser()== null)
        {
            startActivity(new Intent(getApplicationContext(),Sign_In.class));
            finish();
        }
    }


    public void Logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Sign_In.class));
        finish();
    }


    public void Calender(View view) {
        startActivity(new Intent(getApplicationContext(),Calender.class));
        finish();
    }
}
