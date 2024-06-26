package pl.financemanagement.Account.Model.Account;

import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDto map(FinancialAccount account){
        AccountDto accountDto = new AccountDto();
        accountDto.setExternalId(account.getExternalId());
        accountDto.setName(account.getName());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAmount(account.getAmount());
        accountDto.setFinancialCurrency(account.getFinancialCurrency());
        return accountDto;
    }

}
