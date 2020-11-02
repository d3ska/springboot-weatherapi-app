package springbootwheaterapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import springbootwheaterapp.demo.api.WeatherApi;
import springbootwheaterapp.demo.model.City;


import java.util.Map;

@Controller
public class WeatherController {

    private WeatherApi weatherController;

    @Autowired
    public WeatherController(WeatherApi weatherController) {
        this.weatherController = weatherController;
    }

    @GetMapping("/search")
    public String getCityWeather(Model model) {
        model.addAttribute("city", new City());
        return "weatherSearch";

    }

    @PostMapping("/weather")
    public String getWeather(@ModelAttribute City city, Model model) {
        Map<String, String> map;
        try {
           map = weatherController.getCityWeather(city.getName());
        }catch(HttpClientErrorException httpClientErrorException){
            model.addAttribute("cityName", city.getName());
            return "notAvailable";
        }
        model.addAttribute("name", map.get("name"));
        model.addAttribute("country", map.get("country"));
        model.addAttribute("localtime", map.get("localtime"));
        model.addAttribute("tempC", map.get("tempC"));
        model.addAttribute("tempF", map.get("tempF"));
        model.addAttribute("pressureMb", map.get("pressureMb"));
        model.addAttribute("description", map.get("description"));
        model.addAttribute("icon", map.get("icon"));
        return "weatherView";
    }


}
