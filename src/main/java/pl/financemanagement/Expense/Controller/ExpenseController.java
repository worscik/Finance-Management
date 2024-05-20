package pl.financemanagement.Expense.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Expense.Model.ExpenseDto;
import pl.financemanagement.Expense.Model.ExpenseRequest;
import pl.financemanagement.Expense.Model.ExpenseResponse;
import pl.financemanagement.Expense.Service.BudgetService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private final BudgetService budgetService;

    public ExpenseController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping()
    ResponseEntity<ExpenseResponse> addExpense(@RequestBody @Valid ExpenseRequest expenseRequest,
                                               BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }
        return ResponseEntity.ok().body(budgetService.addExpense(expenseRequest));
    }

    @GetMapping("/{externalId}")
    ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable @Valid String externalId,
                                                   BindingResult result) {
        ExpenseResponse response = new ExpenseResponse();
        if (result.hasErrors()) {
            return handleValidationErrors(result);
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
    ResponseEntity<ExpenseResponse> upsertExpose(@RequestBody @Valid ExpenseRequest expenseRequest,
                                                 BindingResult result) {
        ExpenseResponse response = new ExpenseResponse();

        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }

        return budgetService.upsertExpense(expenseRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(response));
    }

    @DeleteMapping("/{externalId}")
    ResponseEntity<HttpStatus> removeExposeById(@PathVariable String externalId) {
        if (externalId == null || externalId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
        budgetService.removeExpense(externalId);
        return ResponseEntity.noContent().build();

    }

    private ResponseEntity<ExpenseResponse> handleValidationErrors(BindingResult result) {
        ExpenseResponse response = new ExpenseResponse();
        List<String> errorMessages = result.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        response.setMessages(errorMessages);
        return ResponseEntity.badRequest().body(response);
    }
}