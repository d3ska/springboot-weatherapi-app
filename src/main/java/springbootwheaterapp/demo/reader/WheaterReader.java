package springbootwheaterapp.demo.reader;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springbootwheaterapp.demo.model.WheaterData;

@Service
public class WheaterReader implements DataReader {

    private static final String URL = "https://api.weatherapi.com/v1/current.json?key=e1288c0f29764daaaad102535200211&q=";


    @Override
    public ResponseEntity getData(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WheaterData> wheaterData= restTemplate.exchange(URL + cityName,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                WheaterData.class);
        return wheaterData;
    }


}
