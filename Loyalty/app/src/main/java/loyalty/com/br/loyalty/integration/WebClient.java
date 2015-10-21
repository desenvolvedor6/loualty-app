package loyalty.com.br.loyalty.integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

/**
 * Created by root on 07/10/15.
 */
public class WebClient {


    private final String urlWebService;

    public WebClient(String urlWebService) {
        this.urlWebService = urlWebService;
    }

    public String getStringFromInputStream(InputStream is) {
        BufferedReader reader = null;
        StringBuilder texto = new StringBuilder();
        String line;
        try {
            reader = new BufferedReader(new InputStreamReader(is));
            while ((line = reader.readLine()) != null) {
                texto.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return texto.toString();
    }

    public String post(String json) {

        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(this.urlWebService);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setRequestProperty("Accept", "application/json; charset=utf-8");
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(json.getBytes());

            if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                InputStream is = httpURLConnection.getInputStream();
                return getStringFromInputStream(is);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
