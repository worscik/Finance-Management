package pl.financemanagement.Expense.Service;

import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Model.ExpenseRequest;
import pl.financemanagement.Expense.Model.ExpenseResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetService {

    Optional<ExpenseResponse> addExpense(ExpenseRequest expenseRequest, ExpenseResponse expenseResponse);

    Optional<ExpenseResponse> getExpenseById(UUID externalID, ExpenseResponse expenseResponse);

    Optional<List<ExpenseDto>> getExpenses();

    Optional<ExpenseDto> upsertExpense();

    Optional<ExpenseDto> removeExpense(UUID externalID);


}
