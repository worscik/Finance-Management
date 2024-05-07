package pl.financemanagement.Expense.Model;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ExpenseMapper {

    public ExpenseDto map(Expense expense){
        ExpenseDto expenseDto = new ExpenseDto(null, false);
        expenseDto.setSuccess(true);
        expenseDto.setAmount(expense.getAmount());
        return expenseDto;
    }

    public Expense map(ExpenseRequest request){
        return new Expense.Builder()
                .withName(request.getName())
                .withCreatedOn(Instant.now())
                .withAmount(request.getAmount())
                .withExternalId(request.getExternalId())
                .build();
    }

}
