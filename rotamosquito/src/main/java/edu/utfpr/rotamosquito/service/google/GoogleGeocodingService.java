package edu.utfpr.rotamosquito.service.google;

import edu.utfpr.rotamosquito.dto.google.GeocodingResponseDTO;
import edu.utfpr.rotamosquito.orm.Dados;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleGeocodingService {

    private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String GOOGLE_KEY = "";

    public void definirCoodernadas(Dados dados) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("address", dados.getDsEndereco())
                .queryParam("key", GOOGLE_KEY);

        final ResponseEntity<GeocodingResponseDTO> exchange = new RestTemplate().exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                GeocodingResponseDTO.class);

        final GeocodingResponseDTO response = exchange.getBody();
        if (response == null || response.getStatus().equals("ZERO_RESULTS")) {
            return;
        }

        dados.setDsEndereco(response.getResults().get(0).getFormattedAddress());
        dados.setDsLatitude(response.getResults().get(0).getGeometry().getLocation().getLat());
        dados.setDsLongitude(response.getResults().get(0).getGeometry().getLocation().getLng());

    }

}
