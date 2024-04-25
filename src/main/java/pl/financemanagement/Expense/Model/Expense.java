package pl.financemanagement.Expense.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID externalId;
    private String name;
    private BigDecimal amount;

    private Expense(Builder builder) {
        this.externalId = builder.externalId;
        this.name = builder.name;
        this.amount = builder.amount;
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

    public BigDecimal getAmount() {
        return amount;
}

public void setAmount(BigDecimal amount) {
    this.amount = amount;
}

public static class Builder {
    private UUID externalId;
    private String name;
    private BigDecimal amount;

    public Builder withExternalId(UUID externalId) {
        this.externalId = externalId;
        return this;
    }

    public Builder withName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        return this;
    }

    public Builder withAmount(BigDecimal amount) {
        if (amount == null || amount.signum() != 1) {
            throw new IllegalArgumentException("Amount cannot be null or negative");
        }
        this.amount = amount;
        return this;
    }

    public Expense build() {
        return new Expense(this);
    }
}

}
