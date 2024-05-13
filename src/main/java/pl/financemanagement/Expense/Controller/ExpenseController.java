package pl.financemanagement.Expense.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Model.ExpenseRequest;
import pl.financemanagement.Expense.Model.ExpenseResponse;
import pl.financemanagement.Expense.Service.BudgetService;

import java.util.Collections;
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
        if(result.hasErrors()) {
            System.out.println(result.hasErrors());
            return ResponseEntity.badRequest().body(new ExpenseResponse(null, result.toString()));
        }
        return ResponseEntity.ok().body(budgetService.addExpense(expenseRequest));
    }

    @GetMapping("/{externalId}")
    ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable UUID externalId) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(externalId)) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        return budgetService.getExpenseById(externalId, response)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(response));
    }

    @GetMapping("/expenses")
    ResponseEntity<List<ExpenseDto>> getExpenses() {
        return ResponseEntity.ok().body(budgetService.getExpenses());
    }

    @PatchMapping("/{externalId}")
    ResponseEntity<ExpenseResponse> upsertExpose(@RequestBody ExpenseRequest expenseRequest) {
        ExpenseResponse response = new ExpenseResponse();
        if (Objects.isNull(expenseRequest.getExternalId())) {
            response.setMessage("ExternalId cannot be empty");
            return ResponseEntity.badRequest().body(response);
        }
        return budgetService.upsertExpense(expenseRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(response));
    }

    @DeleteMapping("/{externalId}")
    ResponseEntity<HttpStatus> removeExposeById(@PathVariable UUID externalId) {
        if (Objects.isNull(externalId)) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
        budgetService.removeExpense(externalId);
        return ResponseEntity.noContent().build();

    }
}