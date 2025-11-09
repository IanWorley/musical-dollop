package xyz.ianworley.flavoroftheday.dto.Culvers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {
    public String type;

    @JsonProperty("coordinates")
    public Object coordinates;  // Use Object to handle both simple arrays and nested arrays
}