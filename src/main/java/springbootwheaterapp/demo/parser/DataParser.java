package springbootwheaterapp.demo.parser;

import java.util.Map;

public interface DataParser<K, V>{

    Map<K, V> parseData(String cityName);
}
