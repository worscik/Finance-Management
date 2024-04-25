package pl.financemanagement.Account.Model.Account;

import java.math.BigDecimal;
import java.time.Instant;

public class AccountDto {

    private long id;
    private String name;
    private String accountNumber;
    private BigDecimal amount;
    private Instant createdOn;
    private FinancialCurrency financialCurrency;
}
