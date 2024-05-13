package pl.financemanagement.Expense.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Expense.Dao.ExpenseDao;
import pl.financemanagement.Expense.Model.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
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
            return new ExpenseResponse(expenseMapper.map(savedExpense), "");
        } catch (Exception e) {
            log.error("Error during add the expense: ", e);
            return new ExpenseResponse(null, "Error during add expose. Contact with us.");
        }
    }

    @Override
    public Optional<ExpenseResponse> getExpenseById(UUID externalID, ExpenseResponse expenseResponse) {
        Optional<Expense> expense = expenseDao.findByExternalId(externalID);
        if (expense.isPresent()) {
            expenseResponse.setExpense(expenseMapper.map(expense.get()));
            return Optional.of(expenseResponse);
        }
        expenseResponse.setMessage("Cannot find expose with UUID: " + externalID);
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
        try{
            Optional<Optional<Expense>> expense = Optional.ofNullable(expenseDao.findByExternalId(expenseRequest.getExternalId()));
            if (expense.isPresent()) {
                Expense exposeToSave = expenseMapper.map(expenseRequest);
                expenseDao.save(exposeToSave);
                return Optional.of(new ExpenseResponse(expenseMapper.map(exposeToSave), ""));
            }
        } catch (Exception e){
            log.error("Error during updated the expense: ", e);
        }
        return Optional.of(new ExpenseResponse(null, "Error during add expose. Contact with us."));
    }

    @Override
    public void removeExpense(UUID externalID) {
        Optional<Expense> expense = expenseDao.findByExternalId(externalID);
        expense.ifPresent(expenseDao::delete);
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
