package pl.financemanagement.Expense.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Dao.ExpenseDao;
import pl.financemanagement.Expense.Model.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Service
public class BudgetServiceImpl implements BudgetService {


    private final ExpenseDao expenseDao;
    private final ExpenseMapper expenseMapper;

    @Autowired
    public BudgetServiceImpl(ExpenseDao expenseDao, ExpenseMapper expenseMapper) {
        this.expenseDao = expenseDao;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public Optional<ExpenseResponse> addExpense(ExpenseRequest expenseRequest, ExpenseResponse expenseResponse) {
        Expense expense = buildExpense(expenseRequest);
        Expense savedExpense = expenseDao.save(expense);
        expenseResponse.setExpense(expenseMapper.map(savedExpense));
        return Optional.of(expenseResponse);
    }

    @Override
    public Optional<ExpenseResponse> getExpenseById(UUID externalID, ExpenseResponse expenseResponse) {
       Optional<Expense> expense = expenseDao.findByExternalId(externalID);
      if(expense.isPresent()){
          expenseResponse.setExpense(expenseMapper.map(expense.get()));
          return Optional.of(expenseResponse);
      }
        expenseResponse.setMessage("Cannot find expose with UUID: " + externalID);
        return Optional.of(expenseResponse);
    }

    @Override
    public Optional<List<ExpenseDto>> getExpenses() {
        return Optional.of(Collections.emptyList());
    }

    @Override
    public Optional<ExpenseDto> upsertExpense() {
        return null;
    }

    @Override
    public Optional<ExpenseDto> removeExpense(UUID externalID) {
        return null;
    }

    private Expense buildExpense(ExpenseRequest request) {
        return new Expense.Builder()
                .withExternalId(UUID.randomUUID())
                .withName(request.getName())
                .withAmount(BigDecimal.valueOf(12.321))
                .withCreatedOn(Instant.now())
                .withVersion(0)
                .build();
    }

}
