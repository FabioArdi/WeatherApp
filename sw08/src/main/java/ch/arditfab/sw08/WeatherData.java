package ch.arditfab.sw08;

public class WeatherData {
    private double temp_c;
    private int humidity;
    private double wind_kph;

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    @Override
    public String toString() {
        return "Temperature: " + temp_c + "°C, Humidity: " + humidity + "%, Wind Speed: " + wind_kph + " kph";
    }
}
