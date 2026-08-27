package getenciamentoTransito.Transito_api.domain.service;

import getenciamentoTransito.Transito_api.domain.model.StatusVeiculo;
import getenciamentoTransito.Transito_api.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ApresencaoVeiculoService {

    private RegistroVeiculoService registroVeiculoService;

    @Transactional
    public void apreender(Long veiucloId){
        Veiculo veiculo= registroVeiculoService.buscar(veiucloId);
        veiculo.apreender();
}



    @Transactional
    public void removerApreensao(Long veiculoId){
       Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
       veiculo.removerApreensao();
    }


    }


