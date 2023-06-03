package ch.arditfab.sw08;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public WeatherData getWeatherData(String location) throws Exception {
        String apiKey = "b4044c0c90de4fadbd4120327230306"; // Replace with your actual API key
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + location;

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String jsonResponse = EntityUtils.toString(entity);
            JSONObject jsonObject = new JSONObject(jsonResponse);

            WeatherData weatherData = new WeatherData();
            weatherData.setTemp_c(jsonObject.getJSONObject("current").getDouble("temp_c"));
            weatherData.setHumidity(jsonObject.getJSONObject("current").getInt("humidity"));
            weatherData.setWind_kph(jsonObject.getJSONObject("current").getDouble("wind_kph"));

            return weatherData;
        }

        return null;
    }
}
