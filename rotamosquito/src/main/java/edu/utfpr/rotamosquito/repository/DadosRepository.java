package edu.utfpr.rotamosquito.repository;

import edu.utfpr.rotamosquito.dto.DadosDTO;
import edu.utfpr.rotamosquito.orm.Dados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DadosRepository extends CrudRepository<Dados, Long> {

    @Query("SELECT new edu.utfpr.rotamosquito.dto.DadosDTO(d.idDado, d.fgSituacao, d.dsLatitude, " +
            "d.dsLongitude, d.dtImportacao) FROM Dados d")
    List<DadosDTO> carregarDadosMapa();

}
