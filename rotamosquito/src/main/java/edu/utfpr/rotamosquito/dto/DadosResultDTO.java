package edu.utfpr.rotamosquito.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosResultDTO {

    private String dsLatitude;

    private String dsLongitude;

    private String dsCidade;

    private List<DadosDTO> listDados = new ArrayList<>();

}
