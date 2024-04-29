package pl.financemanagement.Account.Model.Account;

public enum FinancialCurrency {

    PLN("PLN"),
    GBP("GBP"),
    EUR("EUR");

    final String currency;

    FinancialCurrency(String currency) {
        this.currency = currency;
    }
}