package com.example.jean.currencyconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    EditText inputAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        inputAmount = (EditText) findViewById(R.id.inputAmount);

        ArrayAdapter<CurrencyConverter.CurrencyType> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                CurrencyConverter.CurrencyType.values());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        findViewById(R.id.convertButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String currency = spinner.getSelectedItem().toString();
        String amount = inputAmount.getText().toString();

        Intent newIntent = new Intent(this, ResultsActivity.class);
        newIntent.putExtra("selectedCurrency", currency);
        newIntent.putExtra("enteredAmount", amount);

        startActivity(newIntent);
    }
}
