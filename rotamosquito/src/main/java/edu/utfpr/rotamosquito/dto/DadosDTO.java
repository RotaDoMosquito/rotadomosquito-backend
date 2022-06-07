package edu.utfpr.rotamosquito.dto;

import edu.utfpr.rotamosquito.enumeration.Situacao;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DadosDTO {

    private Long idDado;

    private Integer fgSituacao;

    private String dsLatitude;

    private String dsLongitude;

    private LocalDate dtOcorrencia;

    public DadosDTO(){}

    public DadosDTO(Long idDado, Situacao fgSituacao, String dsLatitude, String dsLongitude, LocalDate dtOcorrencia) {
        this.idDado = idDado;
        this.fgSituacao = fgSituacao.ordinal();
        this.dsLatitude = dsLatitude;
        this.dsLongitude = dsLongitude;
        this.dtOcorrencia = dtOcorrencia;
    }
}
