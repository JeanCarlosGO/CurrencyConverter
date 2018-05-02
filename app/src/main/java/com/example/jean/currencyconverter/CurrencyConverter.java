package com.example.jean.currencyconverter;

public class CurrencyConverter {
    private CurrencyType type;
    private double amount;

    public CurrencyConverter(CurrencyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public static CurrencyConverter from(String currencyName) throws IllegalArgumentException {
        CurrencyConverter currencyConverter = new CurrencyConverter(null, 0.0);
        CurrencyType currencyType = null;
        for(CurrencyType type: CurrencyType.values()) {
            if(type.toString().equals(currencyName)) {
                currencyType = type;
            }
        }
        if(currencyType != null) {
            currencyConverter.type = currencyType;

            return  currencyConverter;
        }

        throw new IllegalArgumentException("Currency Name '" + currencyName + "' is not known.");
    }

    public CurrencyType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double convertTo(CurrencyType cur) {
        return this.amount * this.type.getExchangeRateTo(cur);
    }


    enum CurrencyType {
        DOP, USD, EUR;

        public double getExchangeRateTo(CurrencyType to) throws IllegalArgumentException {
            if(this.equals(to)) return 1.00;

            switch (this) {
                case DOP: // Convert DOP to
                    switch (to) {
                        case USD: return 0.020; // to USD
                        case EUR: return 0.017; // to EUR
                    }

                case USD: // Convert USD to
                    switch (to) {
                        case DOP: return 49.47; // to DOP
                        case EUR: return 0.820; // to EUR
                    }

                case EUR: // Convert EUR to
                    switch (to) {
                        case USD: return 1.210; // to USD
                        case DOP: return 60.09; // to DOP
                    }
            }

            throw new IllegalArgumentException("Unknown Currency: " + to.toString());
        }
    }
}