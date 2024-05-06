package pl.financemanagement.Expense.Dao;

import org.springframework.data.repository.CrudRepository;
import pl.financemanagement.Expense.Model.Expense;
import pl.financemanagement.Expense.Service.BudgetServiceImpl;

public interface ExpenseDao extends CrudRepository<Expense, Long> {
}
