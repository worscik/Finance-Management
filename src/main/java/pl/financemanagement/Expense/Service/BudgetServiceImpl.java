package pl.financemanagement.Expense.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Dao.ExpenseDao;
import pl.financemanagement.Expense.Model.ExpenseRequest;

import java.util.List;
import java.util.UUID;

@Service
public class BudgetServiceImpl implements BudgetService{

    @Autowired
    private final ExpenseDao expenseDao;

    public BudgetServiceImpl(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public ExpenseDto addExpense(ExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public ExpenseDto getExpenseById(ExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public List<ExpenseDto> getExpenses(UUID externalID) {
        return List.of();
    }

    @Override
    public ExpenseDto upsertExpense() {
        return null;
    }

    @Override
    public ExpenseDto removeExpense(UUID externalID) {
        return null;
    }
}
