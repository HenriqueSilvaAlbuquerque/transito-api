package getenciamentoTransito.Transito_api.controller;

import getenciamentoTransito.Transito_api.domain.model.Proprietario;
import getenciamentoTransito.Transito_api.domain.repository.ProprietarioRepository;
import getenciamentoTransito.Transito_api.domain.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")

public class ProprietarioController {
    private final RegistroProprietarioService registroProprietarioService;
    private final ProprietarioRepository proprietarioRepository;

    @GetMapping()
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }

    @GetMapping("{proprietarioId}")
    public ResponseEntity buscar(@PathVariable Long proprietarioId){
     return proprietarioRepository.findById(proprietarioId)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario adicionar(@Valid @RequestBody Proprietario proprietario){ 
    return registroProprietarioService.salvar(proprietario);

}

    @PutMapping("/{proprietarioId}")
        public ResponseEntity<Proprietario> atualizar(@PathVariable Long proprietarioId,
                                                      @RequestBody Proprietario proprietario) {
        if (!proprietarioRepository.existsById(proprietarioId)) {
                return ResponseEntity.notFound().build();
            }

        proprietario.setId(proprietarioId);
        Proprietario proprietarioAtualizado = registroProprietarioService.salvar(proprietario);

        return ResponseEntity.ok(proprietarioAtualizado);
    }
    @DeleteMapping("{proprietarioId}")
       public ResponseEntity<Void> remover(@PathVariable Long proprietarioId){
            if(!proprietarioRepository.existsById(proprietarioId)){
                  return ResponseEntity.notFound().build();
            }
            registroProprietarioService.excluir(proprietarioId);
            return ResponseEntity.noContent().build();
       }
}
