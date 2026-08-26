package getenciamentoTransito.Transito_api.controller;

import getenciamentoTransito.Transito_api.RepresentModel.VeiculoRepresentModel;
import getenciamentoTransito.Transito_api.RepresentModel.input.VeiculoInput;
import getenciamentoTransito.Transito_api.assembler.VeiculoAssembler;
import getenciamentoTransito.Transito_api.domain.model.Veiculo;
import getenciamentoTransito.Transito_api.domain.repository.VeiculoRepository;
import getenciamentoTransito.Transito_api.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoAssembler veiculoAssembler;

    @GetMapping
    public List<VeiculoRepresentModel> listar() {
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoRepresentModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoRepresentModel cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
        Veiculo novoVeiculo=veiculoAssembler.toEntity(veiculoInput);
        Veiculo veiculoCadrastado=registroVeiculoService.cadastrar(novoVeiculo);
        return veiculoAssembler.toModel(veiculoCadrastado);
    }
}