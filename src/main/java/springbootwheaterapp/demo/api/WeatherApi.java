package springbootwheaterapp.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootwheaterapp.demo.parser.DataParser;

import java.util.Map;

@RestController
public class WeatherApi {

    private DataParser dataParser;

    @Autowired
    public WeatherApi(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @GetMapping
    public Map getCityWeather(String cityName){
        return dataParser.parseData(cityName);
    }
}
