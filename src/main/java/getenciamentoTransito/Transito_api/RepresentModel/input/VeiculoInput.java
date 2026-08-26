package getenciamentoTransito.Transito_api.RepresentModel.input;

import getenciamentoTransito.Transito_api.domain.model.StatusVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class VeiculoInput {

    @NotBlank
    @Size(max = 20)
    private String marca;

    @NotBlank
    @Size(max = 20)
    private String modelo;

    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9][A-Z0-9][0-9]{2}")
    private String placa;


    @Valid
    @NotNull
    private ProprietarioIdInput proprietario;





}
