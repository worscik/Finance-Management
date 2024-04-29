package pl.financemanagement.Account.Service;

import pl.financemanagement.Account.Model.Account.AccountDto;
import pl.financemanagement.Account.Model.Account.AccountRequest;
import pl.financemanagement.Account.Model.Account.BasicAccountRequest;

import java.util.Optional;
import java.util.UUID;

public interface FinancialAccountService {

    Optional<AccountDto> saveAccount(AccountRequest accountRequest);

    Optional<AccountDto> getAccount(UUID externalId);

    Optional<AccountDto> upsertAccount(AccountRequest accountRequest);

    void deleteAccount(BasicAccountRequest BasicAccountRequest);

}
