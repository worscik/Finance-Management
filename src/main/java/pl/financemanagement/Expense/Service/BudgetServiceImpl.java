package pl.financemanagement.Expense.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Dao.ExpenseDao;
import pl.financemanagement.Expense.Model.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {


    private static final Logger log = LoggerFactory.getLogger(BudgetServiceImpl.class);
    private final ExpenseDao expenseDao;
    private final ExpenseMapper expenseMapper;

    @Autowired
    public BudgetServiceImpl(ExpenseDao expenseDao, ExpenseMapper expenseMapper) {
        this.expenseDao = expenseDao;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public ExpenseResponse addExpense(ExpenseRequest expenseRequest) {
        try {
            Expense expense = buildExpense(expenseRequest);
            Expense savedExpense = expenseDao.save(expense);
            return new ExpenseResponse(expenseMapper.map(savedExpense), List.of(""));
        } catch (Exception e) {
            log.error("Error during add the expense: ", e);
            return new ExpenseResponse(null, List.of("Error during add expose. Contact with us."));
        }
    }

    @Override
    public Optional<ExpenseResponse> getExpenseById(String externalID, ExpenseResponse expenseResponse) {
        Optional<Expense> expense = expenseDao.findByExternalId(externalID);
        if (expense.isPresent()) {
            expenseResponse.setExpense(expenseMapper.map(expense.get()));
            return Optional.of(expenseResponse);
        }
        expenseResponse.setMessages(List.of("Cannot find expose with UUID: " + externalID));
        return Optional.of(expenseResponse);
    }

    @Override
    public List<ExpenseDto> getExpenses() {
        List<Expense> expenses = (List<Expense>) expenseDao.findAll();
        return expenses.stream()
                .map(expenseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ExpenseResponse> upsertExpense(ExpenseRequest expenseRequest) {
        try {
            Optional<Expense> existingExpense = expenseDao.findByExternalId(expenseRequest.getExternalId());
            if (existingExpense.isPresent()) {
                Expense expenseToSave = expenseMapper.map(expenseRequest);
                Expense savedExpense = expenseDao.save(expenseToSave);
                return Optional.of(new ExpenseResponse(expenseMapper.map(savedExpense), List.of("")));
            } else {
                return Optional.of(new ExpenseResponse(null, List.of("Expense not found for update.")));
            }
        } catch (Exception e) {
            log.error("Error during updated the expense: ", e);
        }
        return Optional.of(new ExpenseResponse(null, List.of("Error during updated expose. Contact with us.")));
    }

    @Override
    public void removeExpense(String externalID) {
        Optional<Expense> expense = expenseDao.findByExternalId(externalID);
        if (expense.isPresent()) {
            expenseDao.delete(expense.get());
            log.info("Expense with UUID: {} has been removed.", externalID);
        } else {
            log.warn("Attempted to remove non-existent expense with UUID: {}", externalID);
        }
    }

    private Expense buildExpense(ExpenseRequest request) {
        return new Expense.Builder()
                .withExternalId(UUID.randomUUID().toString())
                .withName(request.getName())
                .withAmount(request.getAmount())
                .withCreatedOn(Instant.now())
                .withVersion(0)
                .build();
    }

}
