package edu.utfpr.rotamosquito.dto.google;

import lombok.Data;

import java.util.List;

@Data
public class GeocodingResponseDTO {

    private String status;

    private List<GeocodingResultDTO> results;

}
