package pl.financemanagement.Expense.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class ExpenseRequest {

    @NotNull(message = "externalId can not be empty")
    private UUID externalId;
    private String name;
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
