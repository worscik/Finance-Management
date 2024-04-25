package pl.financemanagement.Account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Account.Model.Account.*;
import pl.financemanagement.Account.Repository.FinancialAccountDao;


import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static pl.financemanagement.Account.Model.Account.FinancialCurrency.PLN;

@Service
public class FinancialAccountServiceImpl implements FinancialAccountService {


    @Autowired
    private final FinancialAccountDao financialAccountDao;
    private final AccountMapper accountMapper;

    public FinancialAccountServiceImpl(FinancialAccountDao financialAccountDao, AccountMapper accountMapper) {
        this.financialAccountDao = financialAccountDao;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto addAccount(AccountRequest accountRequest) {
        FinancialAccount account = buildFinanceAccount(accountRequest);
        FinancialAccount savedAccount = financialAccountDao.save((account));
        return accountMapper.map(savedAccount);
    }

    @Override
    public AccountDto getAccount(BasicAccountRequest request) {
        FinancialAccount account = financialAccountDao.findAccountByExternalId(UUID.fromString(request.getUUID()));
        return accountMapper.map(account);
    }

    @Override
    public AccountDto upsertAccount(AccountRequest request) {
        Optional<FinancialAccount> account = Optional.ofNullable(financialAccountDao.findAccountByExternalId(UUID.fromString(request.getUUID())));
        if(account.isPresent()){
            FinancialAccount savedAccount = financialAccountDao.save((account.get()));
            return accountMapper.map(savedAccount);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAccount(BasicAccountRequest request) {
        Optional<FinancialAccount> account = Optional.ofNullable(
                financialAccountDao.findAccountByExternalId(UUID.fromString(request.getUUID())));
        if (account.isPresent()){
            financialAccountDao.delete(account.get());
            return true;
        } else {
            return false;
        }
    }

    private FinancialAccount buildFinanceAccount(AccountRequest accountRequest){
        return new FinancialAccount.Builder()
                .withExternalId(UUID.randomUUID())
                .withName(accountRequest.getName())
                .withAccountNumber(null)
                .withAmount(accountRequest.getAmount())
                .withCurrency(accountRequest.getFinancialCurrency())
                .build();
    }
}
