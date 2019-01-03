import java.util.ArrayList;

public class Currency {

        private String table;
        private String currency;
        private String code;
        private ArrayList rates;

    public Currency(String table, String currency, String code, ArrayList rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
            return table;
        }

        public String getCurrency() {
            return currency;
        }

        public String getCode() {
            return code;
        }

    public ArrayList getRates() {
        return rates;
    }

    public void setRates(ArrayList rates) {
        this.rates = rates;
    }

    public void setTable(String table) {
            this.table = table;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setCode(String code) {
            this.code = code;
        }

    @Override
    public String toString() {
        return "Currency{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
