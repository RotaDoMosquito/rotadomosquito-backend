package edu.utfpr.rotamosquito.service.google;

import edu.utfpr.rotamosquito.dto.DadosResultDTO;
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

    private static final String URL = "https://nominatim.openstreetmap.org/search";

    public void definirCoodernadas(Dados dados) {

//        if (dados.getDsEndereco() == null || dados.getDsEndereco().isEmpty() ||
//                dados.getDsEndereco().equalsIgnoreCase("Dois Vizinhos")){
//            return;
//        }

        final GeocodingResponseDTO response = realizarCredito(dados.getDsEndereco());
        if (response == null){
            return;
        }

        //dados.setDsEndereco(response.getAddress().getTown());
        dados.setDsLatitude(response.getLat());
        dados.setDsLongitude(response.getLon());
    }

    public DadosResultDTO buscarEndereco(String dsEndereco) {

        final GeocodingResponseDTO response = realizarCredito(dsEndereco);
        if (response == null){
            return new DadosResultDTO();
        }

        DadosResultDTO dados = new DadosResultDTO();
        dados.setDsCidade(response.getAddress().getTown());
        dados.setDsLatitude(response.getLat());
        dados.setDsLongitude(response.getLon());
        return dados;
    }

    //--

    private GeocodingResponseDTO realizarCredito(String dsEndereco){

        final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("q", dsEndereco)
                .queryParam("format", "json")
                .queryParam("addressdetails", "1");

        final ResponseEntity<GeocodingResponseDTO[]> exchange = new RestTemplate().exchange(
                builder.build().toUri(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                GeocodingResponseDTO[].class);

        if (exchange.getBody() == null){
            return null;
        }

        for (GeocodingResponseDTO result : exchange.getBody()) {
            return result;
        }

        return null;
    }
}
