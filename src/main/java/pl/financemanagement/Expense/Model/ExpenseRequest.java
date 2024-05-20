package pl.financemanagement.Expense.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ExpenseRequest {

    @Size(min = 1, max = 128, message = "ExternalId cannot be empty")
    private String externalId;
    @Size(min = 1, max = 128, message = "Name can not be empty")
    private String name;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    public ExpenseRequest(String externalId, String name, BigDecimal amount) {
        this.externalId = externalId;
        this.name = name;
        this.amount = amount;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
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
