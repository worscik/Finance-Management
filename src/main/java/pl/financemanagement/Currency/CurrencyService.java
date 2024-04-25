package pl.financemanagement.Currency;

import org.hibernate.type.descriptor.java.CurrencyJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.financemanagement.Account.Model.Account.FinancialCurrency;

import java.math.BigDecimal;

@Service
public class CurrencyService {

    @Autowired
    private final RestTemplate restTemplate;


    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal getCurrentCurrencyRate(FinancialCurrency financialCurrency){
        return BigDecimal.valueOf(0.321321312);
    }


}

