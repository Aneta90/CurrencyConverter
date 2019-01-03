import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<CurrencyConverter> converters = new ArrayList<>();
        converters.add(new CHF_Converter());
        converters.add(new GPB_Converter());
        converters.add(new EUR_Converter());
        converters.add(new USD_Converter());

        MultiConverter multiConverter = new MultiConverter(converters);
        CHF_Converter chf_converter = new CHF_Converter();
        GPB_Converter gpb_converter = new GPB_Converter();
        EUR_Converter eur_converter = new EUR_Converter();
        USD_Converter usd_converter = new USD_Converter();

        System.out.println("100 PLN is worth " + multiConverter.convert(chf_converter, 100) + " chf");
        System.out.println("100 PLN is worth " + multiConverter.convert(gpb_converter, 100) + " gpb");
        System.out.println("100 PLN is worth " + multiConverter.convert(eur_converter, 100) + " eur");
        System.out.println("100 PLN is worth " + multiConverter.convert(usd_converter, 100) + " usd");


        System.out.println("100 PLN you exchanged one month ago for USD costs now " + multiConverter.convertNowAsk(usd_converter, multiConverter.convertPastBid(usd_converter, 100)) + " zl " + multiConverter.interpretator(100, multiConverter.convertNowAsk(usd_converter, multiConverter.convertPastBid(usd_converter, 100))));

        System.out.println("100 PLN you exchanged one month ago for EUR costs now " + multiConverter.convertNowAsk(eur_converter,multiConverter.convertPastBid(eur_converter,100)) + " zl " + multiConverter.interpretator(100, multiConverter.convertNowAsk(eur_converter,multiConverter.convertPastBid(eur_converter,100))));

        System.out.println("100 PLN you exchanged one month ago for GPB costs now " + multiConverter.convertNowAsk(gpb_converter,multiConverter.convertPastBid(gpb_converter,100)) + " zl " + multiConverter.interpretator(100, multiConverter.convertNowAsk(gpb_converter,multiConverter.convertPastBid(gpb_converter,100))));

        System.out.println("100 PLN you exchanged one month ago for CHF costs now " + multiConverter.convertNowAsk(chf_converter,multiConverter.convertPastBid(chf_converter,100)) + " zl " + multiConverter.interpretator(100, multiConverter.convertNowAsk(chf_converter,multiConverter.convertPastBid(chf_converter,100))));





    }
}
