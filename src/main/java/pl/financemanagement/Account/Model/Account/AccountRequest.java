package pl.financemanagement.Account.Model.Account;

import java.math.BigDecimal;

public class AccountRequest extends BasicAccountRequest{

    private BigDecimal amount;
    private FinancialCurrency financialCurrency;
    private String name;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FinancialCurrency getFinancialCurrency() {
        return financialCurrency;
    }

    public void setFinancialCurrency(FinancialCurrency financialCurrency) {
        this.financialCurrency = financialCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
