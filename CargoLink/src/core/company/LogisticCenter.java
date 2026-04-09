public class LogisticsCenter {

    private String name;
    private String city;
    private String country;
    private float latitude;
    private float longitude;

    public LogisticsCenter(String name, String city, String country, float latitude, float longitude) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters necesarios para el main
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
