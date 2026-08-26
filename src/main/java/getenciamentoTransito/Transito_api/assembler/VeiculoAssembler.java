package getenciamentoTransito.Transito_api.assembler;

import getenciamentoTransito.Transito_api.RepresentModel.VeiculoRepresentModel;
import getenciamentoTransito.Transito_api.RepresentModel.input.VeiculoInput;
import getenciamentoTransito.Transito_api.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {
    private final ModelMapper modelMapper;


    public Veiculo toEntity(VeiculoInput veiculoInput ){
        return modelMapper.map(veiculoInput,Veiculo.class);
    }

    public VeiculoRepresentModel toModel(Veiculo veiculo){
        return modelMapper.map(veiculo, VeiculoRepresentModel.class);
    }

    public List<VeiculoRepresentModel> toCollectionModel(List<Veiculo> veiculos){
        return veiculos.stream()
                .map(this::toModel)
                .toList();
    }
}
