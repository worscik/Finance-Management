package pl.financemanagement.Currency;

import java.util.List;

public class CurrencyResponse {

    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;

    public CurrencyResponse(String table, String currency, String code, List<Rates> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }

    public static class Rates {

        private String no;
        private String effectiveDate;
        private double mid;

        public Rates(String no, String effectiveDate, double mid) {
            this.no = no;
            this.effectiveDate = effectiveDate;
            this.mid = mid;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public void setEffectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
        }

        public double getMid() {
            return mid;
        }

        public void setMid(double mid) {
            this.mid = mid;
        }
    }
}
