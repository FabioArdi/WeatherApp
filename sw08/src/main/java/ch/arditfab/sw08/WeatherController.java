package ch.arditfab.sw08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam("location") String location, Model model) {
        try {
            WeatherData weatherData = weatherService.getWeatherData(location);
            model.addAttribute("weatherData", weatherData);
            model.addAttribute("location", location);
        } catch (Exception e) {
            model.addAttribute("error", "Failed to fetch weather data.");
        }

        return "weather";
    }
}
