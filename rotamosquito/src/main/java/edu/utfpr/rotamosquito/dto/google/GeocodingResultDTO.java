package edu.utfpr.rotamosquito.dto.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GeocodingResultDTO {

    @JsonProperty("address_components")
    private List<?> addressComponents;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("geometry")
    private GeocodingGeometryDTO geometry;

}
