package pl.financemanagement.Account.Model.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
public class FinancialAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID externalId;
    private String name;
    private String accountNumber;
    private BigDecimal amount;
    private Instant createdOn;
    private FinancialCurrency financialCurrency;

    private FinancialAccount(Builder builder) {
        this.externalId = builder.externalId;
        this.name = builder.name;
        this.accountNumber = builder.accountNumber;
        this.amount = builder.amount;
        this.createdOn = builder.createdOn;
        this.financialCurrency = builder.financialCurrency;
    }

    public long getId() {
        return id;
    }

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

    public static class Builder{
        private UUID externalId;
        private String name;
        private String accountNumber;
        private BigDecimal amount;
        private Instant createdOn;
        private FinancialCurrency financialCurrency;

        public Builder withExternalId(UUID externalId) {
            this.externalId = externalId;
            return this;
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }
        public Builder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }
        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }
        public Builder createdOn(Instant createdOn) {
            this.createdOn = createdOn;
            return this;
        }
        public Builder withCurrency(FinancialCurrency financialCurrency) {
            this.financialCurrency = financialCurrency;
            return this;
        }

        public FinancialAccount build(){
            return new FinancialAccount(this);
        }


    }
}
