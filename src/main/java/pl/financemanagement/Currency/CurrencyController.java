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

    @GetMapping("/getEuroExchangeRate")
    BigDecimal getBritishPoundExchangeRate(){
        return null;
    }

    @GetMapping("/getEuroExchangeRate")
    BigDecimal getDollarExchangeRate(){
        return null;
    }

}
