import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class GPB_Converter implements CurrencyConverter{

    @Override
    public Currency getCurrency() throws IOException {
        Gson gson = new Gson();
        Currency currency = gson.fromJson(String.valueOf(CurrencyConverter.jsonObject("http://api.nbp.pl/api/exchangerates/rates/a/gbp/")),Currency.class);
        return currency;
    }

    @Override
    public Currency getCurencyPast() throws IOException {
        Gson gson = new Gson();
        LocalDate localDate = LocalDate.now().minusMonths(1);

        if(String.valueOf(localDate.getDayOfWeek()).equals("SUNDAY")){
            localDate= localDate.minusDays(2);
        }
        if(String.valueOf(localDate.getDayOfWeek()).equals("SATURDAY")){
            localDate=localDate.minusDays(1);
        }
        return gson.fromJson(String.valueOf(CurrencyConverter.jsonObject("http://api.nbp.pl/api/exchangerates/rates/c/gbp/" + localDate +"/?format=json")),Currency.class);
    }

    @Override
    public Currency getCurrncyNow() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(CurrencyConverter.jsonObject("http://api.nbp.pl/api/exchangerates/rates/c/gbp/today/")),Currency.class);
    }
}
