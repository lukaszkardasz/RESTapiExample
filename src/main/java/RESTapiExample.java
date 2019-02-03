import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.Scanner;

public class RESTapiExample {

    public static void main(String[] args) throws URISyntaxException, IOException {

        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("reqres.in")
                .setPath("/api/users?page=2")
                .build();
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpget);
        String content = EntityUtils.toString(response.getEntity());
        //content = content.substring(1, content.length() - 1); //opcjonalnie gdy content jest otoczony []




        //show language and area of Poland

//        String area = json.get("area").toString();
//        System.out.println("Polska ma " + area + " km2 powierzchni!");
//        JSONArray languagesArray = (JSONArray) json.get("languages");
//        JSONObject languages = (JSONObject) languagesArray.get(0);
//
//        String glownyJezyk = languages.get("nativeName").toString();
//        System.out.println("Głównym jezykiem jest " + glownyJezyk +"!");

        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Pokaz uzytkowników");
        System.out.println("2. Utwórz użytkownika");
        System.out.println("3. Zakończ program");

        char letter;
        Scanner kb = new Scanner(System.in);
        letter = kb.next().charAt(0);

        switch(Character.toUpperCase(letter))
        {
            case '1':
                JSONObject json = new JSONObject(content);
                System.out.println(json);
                break;
            case '2':
                JSONObject newUser = new JSONObject(content);
                System.out.println(newUser);
                break;
            case '3':
                System.exit(0);
                break;

        }



    }
}
