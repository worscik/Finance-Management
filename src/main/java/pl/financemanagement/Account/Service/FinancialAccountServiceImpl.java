package pl.financemanagement.Account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.financemanagement.Account.Model.Account.*;
import pl.financemanagement.Account.Repository.FinancialAccountDao;

import java.time.Instant;
import java.util.*;

@Service
public class FinancialAccountServiceImpl implements FinancialAccountService {

    private final List<String> numbersToAccount = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");


    @Autowired
    private final FinancialAccountDao financialAccountDao;
    private final AccountMapper accountMapper;
    Random random = new Random();

    public FinancialAccountServiceImpl(FinancialAccountDao financialAccountDao, AccountMapper accountMapper) {
        this.financialAccountDao = financialAccountDao;
        this.accountMapper = accountMapper;
    }

    @Override
    public Optional<AccountDto> saveAccount(AccountRequest accountRequest) {
        FinancialAccount account = buildFinanceAccount(accountRequest);
        FinancialAccount savedAccount = financialAccountDao.save((account));
        return Optional.ofNullable(accountMapper.map(savedAccount));
    }

    @Override
    public Optional<AccountDto> getAccount(UUID externalId) {
        try {
            FinancialAccount account = financialAccountDao.findAccountByExternalId(externalId).orElseThrow();
            return Optional.ofNullable(accountMapper.map(account));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<AccountDto> upsertAccount(AccountRequest request) {
        try {
            FinancialAccount account = financialAccountDao.findAccountByExternalId(UUID.fromString(request.getUUID())).orElseThrow();
            FinancialAccount savedAccount = financialAccountDao.save((account));
            return Optional.ofNullable(accountMapper.map(savedAccount));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }

    }

    @Override
    public void deleteAccount(BasicAccountRequest request) {
        financialAccountDao.deleteByExternalId(UUID.fromString(request.getUUID()));
    }

    private FinancialAccount buildFinanceAccount(AccountRequest accountRequest) {
        return new FinancialAccount.Builder()
                .withExternalId(UUID.randomUUID())
                .withName(accountRequest.getName())
                .withAccountNumber(generateAccountNumber())
                .withAmount(accountRequest.getAmount())
                .withCurrency(accountRequest.getFinancialCurrency())
                .createdOn(Instant.now())
                .build();
    }

    private String generateAccountNumber() {
        StringBuilder number = new StringBuilder();
        for (int i = 1; i <= 32; i++) {
            int generateNumber = random.nextInt(0, 9);
            number.append(numbersToAccount.get(generateNumber));
        }
        return number.toString();
    }
}
