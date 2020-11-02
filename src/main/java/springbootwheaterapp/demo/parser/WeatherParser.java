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
public class WeatherParser implements DataParser<String, String>{

    private DataReader dataReader;
    private Map<String, String> mostImportantWeatherInfo;

    @Autowired
    public WeatherParser(DataReader dataReader) {
        this.dataReader = dataReader;
        this.mostImportantWeatherInfo = new HashMap<>();
    }


    @Override
    public Map<String, String> parseData(String cityName) {
        this.mostImportantWeatherInfo = addMostImportantInfoToMap(cityName);
        return mostImportantWeatherInfo;
    }


    private Map<String, String> addMostImportantInfoToMap(String cityName) {
        WheaterData wheaterData = (WheaterData) dataReader.getData(cityName).getBody();
        Map<String, String> result = new HashMap<>();
        String name = wheaterData.getLocation().getName();
        String country = wheaterData.getLocation().getCountry();
        String localtime = wheaterData.getLocation().getLocaltime();
        String tempC = String.valueOf(wheaterData.getCurrent().getTempC()) + "°C";
        String tempF = String.valueOf(wheaterData.getCurrent().getTempF()) + "°F";
        String pressureMb = String.valueOf(wheaterData.getCurrent().getPressureMb() + "kPa");
        String description = wheaterData.getCurrent().getCondition().getText();
        String icon = wheaterData.getCurrent().getCondition().getIcon();
        result.put("name", name);
        result.put("country", country);
        result.put("localtime", localtime);
        result.put("tempC", tempC);
        result.put("tempF", tempF);
        result.put("pressureMb", pressureMb);
        result.put("description", description);
        result.put("icon", icon);
        return result;
    }


}
