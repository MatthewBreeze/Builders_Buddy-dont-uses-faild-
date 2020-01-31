package com.example.buildersbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.buildersbuddy.TradsCard.TradeCards;
import com.example.buildersbuddy.tax.TaxPage;
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
        startActivity(new Intent(getApplicationContext(), Calender.class));
        finish();
    }

    public void TradeCards(View view) {
        startActivity(new Intent(getApplicationContext(), TradeCards.class));
        finish();
    }

    public void TaxPage(View view) {
        startActivity(new Intent(getApplicationContext(), TaxPage.class));
        finish();
    }

    public void JobsList(View view) {
        startActivity(new Intent(getApplicationContext(),TaxPage.class));
        finish();
    }
}
