package pl.financemanagement.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency/")
public class CurrencyController {

    @GetMapping("/getEuroExchangeRate")
    BigDecimal getEuroExchangeRate(){
        return null;
    }

    @GetMapping("/getBritishPoundExchangeRate")
    BigDecimal getBritishPoundExchangeRate(){
        return null;
    }

    @GetMapping("/getDollarExchangeRate")
    BigDecimal getDollarExchangeRate(){
        return null;
    }

}
