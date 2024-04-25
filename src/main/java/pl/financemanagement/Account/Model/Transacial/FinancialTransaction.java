package pl.financemanagement.Account.Model.Transacial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String expanseName;
    private BigDecimal amount;
    private BigDecimal amountBefore;
    private long transactionsNumber;
    private Instant createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpanseName() {
        return expanseName;
    }

    public void setExpanseName(String expanseName) {
        this.expanseName = expanseName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountBefore() {
        return amountBefore;
    }

    public void setAmountBefore(BigDecimal amountBefore) {
        this.amountBefore = amountBefore;
    }

    public long getTransactionsNumber() {
        return transactionsNumber;
    }

    public void setTransactionsNumber(long transactionsNumber) {
        this.transactionsNumber = transactionsNumber;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
}
