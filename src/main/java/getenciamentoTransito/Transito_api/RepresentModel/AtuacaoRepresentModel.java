package getenciamentoTransito.Transito_api.RepresentModel;


import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class AtuacaoRepresentModel {
    private Long id;
    private String descricao;
    private String valorMulta;
    private OffsetDateTime dataOcorrencia;


}
