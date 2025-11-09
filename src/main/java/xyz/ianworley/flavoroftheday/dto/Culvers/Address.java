package xyz.ianworley.flavoroftheday.dto.Culvers;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Address{
    public String addressLabel;
    public String city;
    public String country;
    public String countryCode;
    public String countryFlag;
    public String county;
    public double distance;
    public String formattedAddress;
    public Geometry geometry;
    public double latitude;
    public double longitude;
    public String postalCode;
    public String state;
    public String stateCode;
    public String layer;
    public TimeZone timeZone;
}
