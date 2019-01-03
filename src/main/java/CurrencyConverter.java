import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public interface CurrencyConverter {

    Currency getCurrency () throws IOException;
    Currency getCurencyPast() throws IOException;
    Currency getCurrncyNow() throws IOException;

    static String jsonObject (String url) throws IOException {

        try (InputStream is = new URL(url).openStream()){
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            return String.valueOf(jsonText);
        }
    }

}
