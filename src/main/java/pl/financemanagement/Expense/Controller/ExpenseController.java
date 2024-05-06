package pl.financemanagement.Expense.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Expense.Model.ExpenseRequest;
import pl.financemanagement.Expense.Model.ExpenseResponse;
import pl.financemanagement.Expense.Service.BudgetService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private final BudgetService budgetService;

    public ExpenseController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping()
    ResponseEntity<ExpenseResponse> addExpense(@RequestBody @Valid ExpenseRequest expenseRequest, BindingResult result) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(expenseRequest.getExternalId())) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        response.setExpense(budgetService.addExpense(expenseRequest));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{externalId}")
    ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable UUID externalId) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(externalId)) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        return null;
    }

    @GetMapping("/")
    ResponseEntity<List<ExpenseResponse>> getExposes() {
        return null;
    }

    @PatchMapping("/{externalId}")
    ResponseEntity<ExpenseResponse> upsertExpose(@RequestBody ExpenseRequest expenseRequest) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(expenseRequest.getExternalId())) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        return null;
    }

    @DeleteMapping("/{externalId}")
    ResponseEntity<Boolean> removeExposeById(@PathVariable UUID externalId) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(externalId)) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }
}