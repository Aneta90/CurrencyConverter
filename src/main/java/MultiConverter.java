import java.io.IOException;
import java.util.ArrayList;

public class MultiConverter {

    private CHF_Converter chf_converter = new CHF_Converter();
    private EUR_Converter eur_converter = new EUR_Converter();
    private GPB_Converter gpb_converter = new GPB_Converter();
    private USD_Converter usd_converter = new USD_Converter();

    public MultiConverter(ArrayList<CurrencyConverter> converters){
        converters.add(chf_converter);
        converters.add(eur_converter);
        converters.add(gpb_converter);
        converters.add(usd_converter);
    }

    public void perform() throws IOException {
        System.out.println("You have to pay " + chf_converter.getCurrency() + " for one chf");
        System.out.println("You have to pay " + eur_converter.getCurrency() + " for one eur");
        System.out.println("You have to pay " + gpb_converter.getCurrency() + " for one gpb");
        System.out.println("You have to pay " + usd_converter.getCurrency() + " for one usd");
    }

    public double convert(CurrencyConverter currencyConverter, int numberOfPLN) throws IOException {
        String [] convertResult = String.valueOf(currencyConverter.getCurrency().getRates()).split(",");
        double value = Double.parseDouble(convertResult[2].replace("mid=","").replace("}]",""));
        double result = Double.parseDouble(String.valueOf(numberOfPLN/value));
        return result;
    }

    public double convertPastBid(CurrencyConverter currencyConverter, double numberOfPLN) throws IOException{
        String[] convertResult = String.valueOf(currencyConverter.getCurencyPast().getRates()).split(",");
        double value = Double.parseDouble(convertResult[2].replace("bid=",""));
        double result = Double.parseDouble(String.valueOf(numberOfPLN/value));
        return result;
    }

    public double convertNowAsk(CurrencyConverter currencyConverter, double numberOfCurrency) throws IOException {
        String[] convertResult = String.valueOf(currencyConverter.getCurrncyNow().getRates()).split(",");
        double value = Double.parseDouble(convertResult[3].replace("ask=","").replace("}]",""));
        double result = Double.parseDouble(String.valueOf(numberOfCurrency*value));
        return result;
    }
    public boolean interpretator(double PLNlastMonth, double PLNnow){

        double result = PLNnow-PLNlastMonth;

        if(PLNnow>PLNlastMonth){
            System.out.println("You have earned " + result);
            return true;
        } else {
            System.out.println("You have lost " + result);
            return false;
        }
    }
}