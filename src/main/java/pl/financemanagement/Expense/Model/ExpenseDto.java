package pl.financemanagement.Expense.Model;

import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseDto {

    private BigDecimal amount;
    private boolean success;
    private String message;

    public ExpenseDto() {
    }

    public ExpenseDto(BigDecimal amount, boolean success, String message) {
        this.amount = amount;
        this.success = success;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}