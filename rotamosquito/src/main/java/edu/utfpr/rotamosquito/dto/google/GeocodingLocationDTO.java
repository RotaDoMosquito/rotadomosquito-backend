package edu.utfpr.rotamosquito.dto.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeocodingLocationDTO {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

}
