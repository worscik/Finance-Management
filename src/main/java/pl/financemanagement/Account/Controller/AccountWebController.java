package pl.financemanagement.Account.Controller;


import org.springframework.web.bind.annotation.*;
import pl.financemanagement.Account.Model.Account.AccountDto;
import pl.financemanagement.Account.Model.Account.AccountRequest;
import pl.financemanagement.Account.Model.Account.BasicAccountRequest;

@RestController
@RequestMapping("/account")
public class AccountWebController {

    @PostMapping()
    AccountDto createAccount(@RequestBody AccountRequest accountRequest){
        return null;
    }

    @GetMapping()
    AccountDto getAccount(@RequestBody BasicAccountRequest basicAccountRequest){
        return null;
    }

    @PatchMapping()
    AccountDto upsertAccount(@RequestBody AccountRequest accountRequest){
        return null;
    }

    @DeleteMapping
    boolean removeAccount(@RequestBody BasicAccountRequest basicAccountRequest){
        return true;
    }
}