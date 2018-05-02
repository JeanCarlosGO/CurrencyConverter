package com.example.jean.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ListView resultsList = (ListView) findViewById(R.id.listView);

        Intent receivedIntent = getIntent();
        String currencyName = receivedIntent.getStringExtra("selectedCurrency");
        double enteredAmount= Double.parseDouble(receivedIntent.getStringExtra("enteredAmount"));

        CurrencyConverter currencyConverter = CurrencyConverter.from(currencyName);
        currencyConverter.setAmount(enteredAmount);

        ArrayList<CurrencyConverter> data = new ArrayList<>();
        for(CurrencyConverter.CurrencyType type: CurrencyConverter.CurrencyType.values()) {
            if(!type.equals(currencyConverter.getType())) {
                double amount = currencyConverter.convertTo(type);
                data.add(new CurrencyConverter(type, amount));
            }
        }

        CurrencyAdapter adapter = new CurrencyAdapter(this, data);
        resultsList.setAdapter(adapter);
    }
}
