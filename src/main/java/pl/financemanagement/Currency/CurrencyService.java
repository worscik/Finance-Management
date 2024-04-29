package pl.financemanagement.Currency;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.financemanagement.Account.Model.Account.FinancialCurrency;

import java.util.Optional;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;
    private static final Logger log = LogManager.getLogger(CurrencyService.class);

    @Autowired
    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<CurrencyResponse> getExchangeRate(FinancialCurrency currency){
        try{
            String URL = resolveUrl(currency);
            return Optional.ofNullable(restTemplate.getForEntity(URL, CurrencyResponse.class).getBody());
        } catch (Exception e){
            log.error("Error during download change rate for: " + currency, e);
        }
        return Optional.empty();
    }

    private String resolveUrl(FinancialCurrency currency){
        switch (currency){
            case GBP -> {
                return "https://api.nbp.pl/api/exchangerates/rates/a/gbp/";
            }
            case EUR -> {
                return "https://api.nbp.pl/api/exchangerates/rates/a/eur/";
            }
            default -> {
                return "";
            }
        }
    }


}

