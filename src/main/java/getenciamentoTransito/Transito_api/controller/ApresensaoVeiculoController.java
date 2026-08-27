package getenciamentoTransito.Transito_api.controller;


import getenciamentoTransito.Transito_api.domain.service.ApresencaoVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/apreensao")

public class ApresensaoVeiculoController {
    private final ApresencaoVeiculoService apresencaoVeiculoService;


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apreender(@Valid @PathVariable Long veiculoId){
        apresencaoVeiculoService.apreender(veiculoId);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerApreesensao(@Valid @PathVariable Long veiculoId){
        apresencaoVeiculoService.removerApreensao(veiculoId);

    }

}
