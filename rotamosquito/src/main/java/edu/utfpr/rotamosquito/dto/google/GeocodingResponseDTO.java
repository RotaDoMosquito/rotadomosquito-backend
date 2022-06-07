package edu.utfpr.rotamosquito.dto.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeocodingResponseDTO {

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lon")
    private String lon;

    @JsonProperty("address")
    private GeocodingResponseDetailDTO address;

}
