package service;

import com.google.gson.*;
import model.Train;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class TrainAPIService {
    private static final String API_KEY = "440f2c6b34msh5dc4a5f8d6a9ae1p14e22cjsn94433a4b3f65";

    public List<Train> getTrains(String from, String to, String date) {
        List<Train> trains = new ArrayList<>();
        try {
            String apiUrl = "https://indian-railway-irctc.p.rapidapi.com/api/v1/searchTrainBetweenStations"
                    + "?fromStationCode=" + from
                    + "&toStationCode=" + to
                    + "&dateOfJourney=" + date;

            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(apiUrl);

            // Required headers
            request.setHeader("x-rapidapi-host", "indian-railway-irctc.p.rapidapi.com");
            request.setHeader("x-rapidapi-key", API_KEY);

            CloseableHttpResponse response = client.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            response.close();
            client.close();

            JsonObject obj = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonArray arr = obj.getAsJsonArray("data");

            if (arr != null) {
                for (JsonElement e : arr) {
                    JsonObject t = e.getAsJsonObject();
                    trains.add(new Train(
                            t.get("train_number").getAsString(),
                            t.get("train_name").getAsString(),
                            t.get("from_std").getAsString(),
                            t.get("to_std").getAsString(),
                            t.get("duration").getAsString(),
                            0 // seat availability not provided in free API
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return trains;
    }
}
