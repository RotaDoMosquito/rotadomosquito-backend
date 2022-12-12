package edu.utfpr.rotamosquito.dto.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeocodingResponseDetailDTO {

    @JsonProperty("town")
    private String town;

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

    
}
