package getenciamentoTransito.Transito_api.RepresentModel;

import getenciamentoTransito.Transito_api.domain.model.StatusVeiculo;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoRepresentModel {
    private Long id;
    private String nomeProprietario;
    private String marca;
    private String modelo;
    private String Placa;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

}
