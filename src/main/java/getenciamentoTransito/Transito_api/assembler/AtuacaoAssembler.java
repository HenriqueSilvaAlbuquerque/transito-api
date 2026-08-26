package getenciamentoTransito.Transito_api.assembler;


import getenciamentoTransito.Transito_api.RepresentModel.AtuacaoRepresentModel;
import getenciamentoTransito.Transito_api.RepresentModel.input.AtuacaoInput;
import getenciamentoTransito.Transito_api.domain.model.Atuacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AtuacaoAssembler {

    private final ModelMapper modelMapper;

    public Atuacao toEntity(AtuacaoInput atuacao){
        return modelMapper.map(atuacao, Atuacao.class);
    }

    public AtuacaoRepresentModel toModel(Atuacao atuacao) {
        return modelMapper.map(atuacao, AtuacaoRepresentModel.class);
    }

    public List<AtuacaoRepresentModel> toCollectionModel(List<Atuacao> atuacoes) {
        return atuacoes.stream()
                .map(this::toModel)
                .toList();
    }

}
