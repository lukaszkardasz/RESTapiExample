import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class RESTapiExample {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            jsonText = jsonText.substring(1, jsonText.length() - 1);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }




    public static void main(String[] args) throws IOException {


        //
        JSONObject json = readJsonFromUrl("https://restcountries.eu/rest/v2/name/Poland");

        String area = json.get("area").toString();
        System.out.println("Polska ma " + area + " km2 powierzchni!");
        JSONArray languagesArray = (JSONArray) json.get("languages");
        JSONObject languages = (JSONObject) languagesArray.get(0);

        String glownyJezyk = languages.get("nativeName").toString();
        System.out.println("Głównym jezykiem jest " + glownyJezyk +"!");
    }
}
