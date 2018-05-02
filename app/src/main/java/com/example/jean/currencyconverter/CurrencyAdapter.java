package com.example.jean.currencyconverter;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jean.currencyconverter.CurrencyConverter;

import java.util.ArrayList;

public class CurrencyAdapter extends ArrayAdapter<CurrencyConverter> {

    public Context context;
    public ArrayList<CurrencyConverter> currencyList;
    private LayoutInflater layoutInflater;

    public CurrencyAdapter(Context context, ArrayList<CurrencyConverter> currencyList) {
        super(context, 0, currencyList);

        this.context = context;
        this.currencyList = currencyList;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final CurrencyConverter currency = getItem(position);

        if(convertView == null) {
            convertView = layoutInflater
                          .inflate(R.layout.item_currency, parent, false);
        }

        TextView currencyName = (TextView) convertView.findViewById(R.id.currencyName);
        TextView amount = (TextView) convertView.findViewById(R.id.currencyAmount);

        currencyName.setText(currency.getType().toString());
        amount.setText(String.format("%.2f", currency.getAmount()));

        return  convertView;
    }
}
