package pl.financemanagement.Expense.Model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public class ExpenseRequest {

    @NotNull(message = "externalId cannot be empty")
    private UUID externalId;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    public ExpenseRequest(UUID externalId, String name, BigDecimal amount) {
        this.externalId = externalId;
        this.name = name;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "ExpenseRequest{" +
                "externalId=" + externalId +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
