package pl.financemanagement.Expense.Dao;

import org.springframework.data.repository.CrudRepository;
import pl.financemanagement.Expense.Model.Expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseDao extends CrudRepository<Expense, Long> {

    Optional<Expense> findByExternalId(UUID externalId);
}
