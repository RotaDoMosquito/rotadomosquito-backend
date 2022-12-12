package edu.utfpr.rotamosquito.repository;

import edu.utfpr.rotamosquito.dto.DadosDTO;
import edu.utfpr.rotamosquito.orm.Dados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DadosRepository extends CrudRepository<Dados, Long> {

    @Query("SELECT new edu.utfpr.rotamosquito.dto.DadosDTO(d.idDado, d.fgSituacao, d.dsLatitude, " +
            "d.dsLongitude, d.dtImportacao) FROM Dados d")
    List<DadosDTO> carregarDadosMapa();
    
    @Query("SELECT new edu.utfpr.rotamosquito.dto.DadosDTO(d.idDado, d.fgSituacao, d.dsLatitude, " +
            "d.dsLongitude, d.dtImportacao) FROM Dados d WHERE d.dsLongitude = :longi and d.dsLatitude = :lati and d.dtOcorrencia = :data_ocorr")
    List<DadosDTO> carregarDadosMapaFilter(@Param("longi") String longi,
            @Param("lati") String lati, @Param("data_ocorr") LocalDate data_ocorr);

}
