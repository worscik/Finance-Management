package pl.financemanagement.Expense.Service;

import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Model.ExpenseRequest;

import java.util.List;
import java.util.UUID;

public interface BudgetService {

    ExpenseDto addExpense(ExpenseRequest expenseRequest);

    ExpenseDto getExpenseById(ExpenseRequest expenseRequest);

    List<ExpenseDto> getExpenses(UUID externalID);

    ExpenseDto upsertExpense();

    ExpenseDto removeExpense(UUID externalID);


}
