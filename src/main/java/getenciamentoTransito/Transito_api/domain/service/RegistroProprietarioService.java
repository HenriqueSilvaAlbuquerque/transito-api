package getenciamentoTransito.Transito_api.domain.service;

import getenciamentoTransito.Transito_api.domain.model.Proprietario;
import getenciamentoTransito.Transito_api.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {
    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
        return proprietarioRepository.save(proprietario);
    }

    public void excluir(Long proprietarioId){
        proprietarioRepository.deleteById(proprietarioId);
    }

}
