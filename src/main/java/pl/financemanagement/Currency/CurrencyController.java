package pl.financemanagement.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.financemanagement.Account.Model.Account.FinancialCurrency;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    @Autowired
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency/getExchangeRate/{currency}")
    ResponseEntity<CurrencyResponse> getExchangeRate(@PathVariable FinancialCurrency currency){
        return currencyService.getExchangeRate(currency)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.internalServerError().build());
    }

}
