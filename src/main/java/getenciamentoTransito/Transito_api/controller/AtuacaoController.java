package getenciamentoTransito.Transito_api.controller;

import getenciamentoTransito.Transito_api.RepresentModel.AtuacaoRepresentModel;
import getenciamentoTransito.Transito_api.RepresentModel.input.AtuacaoInput;
import getenciamentoTransito.Transito_api.assembler.AtuacaoAssembler;
import getenciamentoTransito.Transito_api.domain.model.Atuacao;
import getenciamentoTransito.Transito_api.domain.service.RegistroAtuacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/atuacoes")
public class AtuacaoController {

    private final RegistroAtuacaoService registroAtuacaoService;
    private final AtuacaoAssembler atuacaoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtuacaoRepresentModel registrar(@PathVariable Long veiculoId, @Valid @RequestBody AtuacaoInput atuacaoInput){

        Atuacao novaAtuacao = atuacaoAssembler.toEntity(atuacaoInput);
        Atuacao autuacaoRegistrada= registroAtuacaoService.registrar(veiculoId,novaAtuacao);
        return atuacaoAssembler.toModel(autuacaoRegistrada);
    }
}
