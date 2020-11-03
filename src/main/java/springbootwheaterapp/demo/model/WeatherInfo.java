package springbootwheaterapp.demo.model;

public class WeatherInfo {
    private String name;
    private String country;
    private String localtime;
    private String tempC;
    private String tempF;
    private String pressureMb;
    private String description;
    private String icon;

    public WeatherInfo(String name, String country, String localtime, String tempC, String tempF, String pressureMb, String description, String icon) {
        this.name = name;
        this.country = country;
        this.localtime = localtime;
        this.tempC = tempC;
        this.tempF = tempF;
        this.pressureMb = pressureMb;
        this.description = description;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(String pressureMb) {
        this.pressureMb = pressureMb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
