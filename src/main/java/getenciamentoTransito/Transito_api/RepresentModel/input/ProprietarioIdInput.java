package getenciamentoTransito.Transito_api.RepresentModel.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioIdInput {
    @NotNull
    private Long id;
}
