package pl.financemanagement.Expense.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID externalId;
    private String name;
    private BigDecimal amount;
    private Instant createdOn;
    private int version;

    private Expense(Builder builder) {
        this.externalId = builder.externalId;
        this.name = builder.name;
        this.amount = builder.amount;
        this.createdOn = builder.createdOn;
        this.version =  builder.version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
    private Instant createdOn;
    private int version;

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

    public Builder withCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Builder withVersion(int version) {
        this.version = version;
        return this;
    }

    public Expense build() {
        return new Expense(this);
    }
}

}
