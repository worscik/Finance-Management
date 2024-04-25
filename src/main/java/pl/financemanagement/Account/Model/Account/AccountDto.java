package pl.financemanagement.Account.Model.Account;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class AccountDto {

    private UUID externalId;
    private String name;
    private String accountNumber;
    private BigDecimal amount;
    private Instant createdOn;
    private FinancialCurrency financialCurrency;

    public UUID getExternalId() {
        return externalId;
    }

    public void setExternalId(UUID externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public FinancialCurrency getFinancialCurrency() {
        return financialCurrency;
    }

    public void setFinancialCurrency(FinancialCurrency financialCurrency) {
        this.financialCurrency = financialCurrency;
    }
}
