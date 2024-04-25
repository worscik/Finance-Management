package pl.financemanagement.Account.Service;

import pl.financemanagement.Account.Model.Account.AccountDto;
import pl.financemanagement.Account.Model.Account.AccountRequest;
import pl.financemanagement.Account.Model.Account.BasicAccountRequest;

import java.util.UUID;

public interface FinancialAccountService {

    AccountDto addAccount(AccountRequest accountRequest);

    AccountDto getAccount(BasicAccountRequest BasicAccountRequest);

    AccountDto upsertAccount(AccountRequest accountRequest);

    boolean deleteAccount(BasicAccountRequest BasicAccountRequest);

}
