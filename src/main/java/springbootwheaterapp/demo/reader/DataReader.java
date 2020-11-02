package springbootwheaterapp.demo.reader;

import org.springframework.http.ResponseEntity;

public interface DataReader {

    ResponseEntity getData(String cityName);
}
