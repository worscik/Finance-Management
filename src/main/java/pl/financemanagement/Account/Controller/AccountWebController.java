package pl.financemanagement.Account.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Account.Model.Account.AccountDto;
import pl.financemanagement.Account.Model.Account.AccountRequest;
import pl.financemanagement.Account.Model.Account.BasicAccountRequest;
import pl.financemanagement.Account.Service.FinancialAccountService;
import pl.financemanagement.Account.Service.FinancialAccountServiceImpl;

@RestController
@RequestMapping("/account")
public class AccountWebController {

    @Autowired
    private final FinancialAccountService financialAccountService;

    public AccountWebController(FinancialAccountServiceImpl financialAccountService) {
        this.financialAccountService = financialAccountService;
    }

    @PostMapping()
    AccountDto createAccount(@RequestBody AccountRequest accountRequest){
        return financialAccountService.addAccount(accountRequest);
    }

    @GetMapping()
    AccountDto getAccount(@RequestBody BasicAccountRequest basicAccountRequest){
        return financialAccountService.getAccount(basicAccountRequest);
    }

    @PatchMapping()
    AccountDto upsertAccount(@RequestBody AccountRequest accountRequest){
        return financialAccountService.upsertAccount(accountRequest);
    }

    @DeleteMapping
    boolean removeAccount(@RequestBody BasicAccountRequest basicAccountRequest){
        return financialAccountService.deleteAccount(basicAccountRequest);
    }
}