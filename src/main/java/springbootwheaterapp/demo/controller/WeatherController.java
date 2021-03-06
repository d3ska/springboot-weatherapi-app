package springbootwheaterapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import springbootwheaterapp.demo.model.City;
import springbootwheaterapp.demo.model.WeatherInfo;
import springbootwheaterapp.demo.parser.DataParser;


import java.util.Map;

@Controller
public class WeatherController {
        private DataParser dataParser;



    @Autowired
    public WeatherController(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @GetMapping("/search")
    public String getCityWeather(Model model) {
        model.addAttribute("city", new City());
        return "weatherSearch";

    }

    @PostMapping("/weather")
    public String getWeather(@ModelAttribute City city, Model model) {
        Map<String, WeatherInfo> map;
        try {
           map = dataParser.parseData(city.getName());
        }catch(HttpClientErrorException httpClientErrorException){
            model.addAttribute("cityName", city.getName());
            return "notAvailable";
        }
        model.addAttribute("weatherInfo", map.get("weatherInfo"));
        return "weatherView";
    }


}
