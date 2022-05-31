package edu.utfpr.rotamosquito.orm;

import edu.utfpr.rotamosquito.enumeration.Situacao;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "dados")
@SequenceGenerator(name = "seq_dado", sequenceName = "seq_dado", allocationSize = 1)
public class Dados implements Serializable {

    @Id
    @Column(name = "id_dado", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dado")
    private Long idDado;

    @Column(name = "dt_importacao", nullable = false, updatable = false)
    private LocalDate dtImportacao;

    @Column(name = "ds_endereco", nullable = false, updatable = false, length = 500)
    private String dsEndereco;

    @Enumerated
    @Column(name = "fg_situacao", nullable = false, updatable = false)
    private Situacao fgSituacao;

    @Column(name = "ds_latitude", updatable = false, length = 100)
    private String dsLatitude;

    @Column(name = "ds_longitude", length = 100)
    private String dsLongitude;

    public Dados(LocalDate dtImportacao, String dsEndereco, String fgSituacao) {
        this.dtImportacao = dtImportacao;
        this.dsEndereco = dsEndereco;
        this.fgSituacao = fgSituacao.toLowerCase().startsWith("positivo")?
                Situacao.POSITIVO : Situacao.NEGATIVO;
    }
}
