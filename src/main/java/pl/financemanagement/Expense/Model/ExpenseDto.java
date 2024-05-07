package pl.financemanagement.Expense.Model;

import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseDto {

    private BigDecimal amount;
    private boolean success;

    public ExpenseDto() {
    }

    public ExpenseDto(BigDecimal amount, boolean success) {
        this.amount = amount;
        this.success = success;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}