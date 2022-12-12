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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public GeocodingResponseDetailDTO getAddress() {
		return address;
	}

	public void setAddress(GeocodingResponseDetailDTO address) {
		this.address = address;
	}
    
    

}
