package springbootwheaterapp.demo.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import springbootwheaterapp.demo.model.WeatherInfo;
import springbootwheaterapp.demo.model.WheaterData;
import springbootwheaterapp.demo.reader.DataReader;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WeatherParser implements DataParser<String, WeatherInfo>{

    private DataReader dataReader;
    private Map<String, WeatherInfo> mostImportantWeatherInfo;

    @Autowired
    public WeatherParser(DataReader dataReader) {
        this.dataReader = dataReader;
        this.mostImportantWeatherInfo = new HashMap<>();
    }


    @Override
    public Map<String, WeatherInfo> parseData(String cityName) {
        this.mostImportantWeatherInfo = addMostImportantInfoToMap(cityName);
        return mostImportantWeatherInfo;
    }


    private Map<String, WeatherInfo> addMostImportantInfoToMap(String cityName) {
        Map<String, WeatherInfo> result = new HashMap<>();
        WeatherInfo weatherInfo = mapToWeatherInfo(cityName);
        result.put("weatherInfo", weatherInfo);
        return result;
    }

    private WeatherInfo mapToWeatherInfo(String cityName) {
        WheaterData wheaterData = (WheaterData) dataReader.getData(cityName).getBody();
        String name = wheaterData.getLocation().getName();
        String country = wheaterData.getLocation().getCountry();
        String localtime = wheaterData.getLocation().getLocaltime();
        String tempC = wheaterData.getCurrent().getTempC() + "°C";
        String tempF = wheaterData.getCurrent().getTempF() + "°F";
        String pressureMb = wheaterData.getCurrent().getPressureMb() + "kPa";
        String description = wheaterData.getCurrent().getCondition().getText();
        String icon = wheaterData.getCurrent().getCondition().getIcon();
        return new WeatherInfo(name, country, localtime, tempC, tempF, pressureMb, description, icon);
    }


}
