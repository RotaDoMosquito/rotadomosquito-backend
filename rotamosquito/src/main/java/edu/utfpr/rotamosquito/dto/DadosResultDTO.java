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

	public String getDsLatitude() {
		return dsLatitude;
	}

	public void setDsLatitude(String dsLatitude) {
		this.dsLatitude = dsLatitude;
	}

	public String getDsLongitude() {
		return dsLongitude;
	}

	public void setDsLongitude(String dsLongitude) {
		this.dsLongitude = dsLongitude;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public List<DadosDTO> getListDados() {
		return listDados;
	}

	public void setListDados(List<DadosDTO> listDados) {
		this.listDados = listDados;
	}
    

}
