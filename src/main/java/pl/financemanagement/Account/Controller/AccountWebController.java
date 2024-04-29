package pl.financemanagement.Account.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Account.Model.Account.AccountDto;
import pl.financemanagement.Account.Model.Account.AccountRequest;
import pl.financemanagement.Account.Model.Account.BasicAccountRequest;
import pl.financemanagement.Account.Service.FinancialAccountService;
import pl.financemanagement.Account.Service.FinancialAccountServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountWebController {

    @Autowired
    private final FinancialAccountService financialAccountService;

    public AccountWebController(FinancialAccountServiceImpl financialAccountService) {
        this.financialAccountService = financialAccountService;
    }

    @PostMapping()
    ResponseEntity<AccountDto> createAccount(@RequestBody AccountRequest accountRequest){
        return financialAccountService.saveAccount(accountRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{externalId}")
    ResponseEntity<AccountDto> getAccount(@PathVariable UUID externalId){
        return financialAccountService.getAccount(externalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping()
    ResponseEntity<AccountDto> replaceAccount(@RequestBody AccountRequest accountRequest){
        return financialAccountService.upsertAccount(accountRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    @PatchMapping()
    ResponseEntity<AccountDto> changeAccount(@RequestBody AccountRequest accountRequest){
        return financialAccountService.upsertAccount(accountRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    ResponseEntity<Boolean> removeAccount(@RequestBody BasicAccountRequest basicAccountRequest){
        financialAccountService.deleteAccount(basicAccountRequest);
        return ResponseEntity.noContent().build();
    }
}