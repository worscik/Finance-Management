package pl.financemanagement.Expense.Controller;

import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Expense.Model.ExpenseRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @PostMapping()
    ExpenseDto addExpense(@RequestBody ExpenseRequest expenseRequest) {
        return null;
    }

    @GetMapping("/{externalId}")
    ExpenseDto getExpenseById(@PathVariable UUID externalId) {
        return null;
    }

    @GetMapping("/")
    List<ExpenseDto> getExposes() {
        return null;
    }

    @PatchMapping("/{externalId}")
    ExpenseDto upsertExpose(@RequestBody ExpenseRequest expenseRequest) {
        return null;
    }

    @DeleteMapping("/{externalId}")
    boolean removeExposeById(@PathVariable UUID externalId) {
        return false;
    }
}