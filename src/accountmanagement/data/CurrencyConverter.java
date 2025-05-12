package accountmanagement.data;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {

    public CurrencyConverter() {
    }

    public static void main(String[] args) {
       
    }

    public double getExchangeRate(String currencyCode) throws Exception {
        String url = "https://doviz.dev/v1/" + currencyCode.toLowerCase() + ".json";
        HttpURLConnection con = null;
        BufferedReader reader = null;

        try {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            JSONObject jsonObj = new JSONObject(response.toString());

            String key = currencyCode.toUpperCase() + "TRY";
            if (jsonObj.has(key)) {
                return jsonObj.getDouble(key);
            } else {
                throw new Exception("Döviz çifti bulunamadı: " + key);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Kur bilgisi alınamadı: " + currencyCode);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (con != null) {
                con.disconnect();
            }
        }
    }
}
