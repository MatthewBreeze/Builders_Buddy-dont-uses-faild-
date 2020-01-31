package com.example.buildersbuddy.TradsCard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.buildersbuddy.R;
import com.example.buildersbuddy.tax.TaxPage;

public class TradeCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_cards);
    }

    public void AddCard(View view)
    {
        startActivity(new Intent(getApplicationContext(), AddCard.class));
        finish();
    }
}
