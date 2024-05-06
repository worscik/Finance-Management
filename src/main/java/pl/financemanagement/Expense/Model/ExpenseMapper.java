package pl.financemanagement.Expense.Model;

public class ExpenseMapper {

    ExpenseDto map(Expense expense){
        ExpenseDto expenseDto = new ExpenseDto(null, false, null);
        expenseDto.setSuccess(true);
        expenseDto.setAmount(expense.getAmount());
        return expenseDto;
    }

}
