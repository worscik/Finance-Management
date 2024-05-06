package pl.financemanagement.Expense.Model;

public class ExpenseResponse {

    ExpenseDto expense;
    String message;

    public ExpenseResponse() {
    }

    public ExpenseResponse(ExpenseDto expense, String message) {
        this.expense = expense;
        this.message = message;
    }

    public ExpenseDto getExpense() {
        return expense;
    }

    public void setExpense(ExpenseDto expense) {
        this.expense = expense;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
