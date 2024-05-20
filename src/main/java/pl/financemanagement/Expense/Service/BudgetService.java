package pl.financemanagement.Expense.Service;

import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Model.ExpenseRequest;
import pl.financemanagement.Expense.Model.ExpenseResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetService {

    ExpenseResponse addExpense(ExpenseRequest expenseRequest);

    Optional<ExpenseResponse> getExpenseById(String externalID, ExpenseResponse expenseResponse);

    List<ExpenseDto> getExpenses();

    Optional<ExpenseResponse> upsertExpense(ExpenseRequest expenseRequest);

    void removeExpense(String externalID);


}
