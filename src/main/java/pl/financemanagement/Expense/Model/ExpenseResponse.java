package pl.financemanagement.Expense.Model;

import java.util.List;

public class ExpenseResponse {

    ExpenseDto expense;
    List<String> messages;

    public ExpenseResponse() {
    }

    public ExpenseResponse(ExpenseDto expense, List<String> messages) {
        this.expense = expense;
        this.messages = messages;
    }

    public ExpenseDto getExpense() {
        return expense;
    }

    public void setExpense(ExpenseDto expense) {
        this.expense = expense;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
