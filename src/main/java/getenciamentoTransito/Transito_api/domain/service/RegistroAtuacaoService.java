package getenciamentoTransito.Transito_api.domain.service;

import getenciamentoTransito.Transito_api.domain.model.Atuacao;
import getenciamentoTransito.Transito_api.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroAtuacaoService {
    private final RegistroVeiculoService registroVeiculoService;


    @Transactional
    public Atuacao registrar(Long veiculoId, Atuacao novaAutuacao){
       Veiculo veiculo=registroVeiculoService.buscar(veiculoId);
       return veiculo.adicionarAtuacao(novaAutuacao);
    }
}
