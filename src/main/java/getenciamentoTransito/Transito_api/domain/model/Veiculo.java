package getenciamentoTransito.Transito_api.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import getenciamentoTransito.Transito_api.domain.exception.NegocioException;
import getenciamentoTransito.Transito_api.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ProprietarioId.class)
    @NotNull
    @ManyToOne
    private Proprietario proprietario;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    @Pattern(regexp="[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    private String placa;

    @JsonProperty(access =JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    @JsonProperty(access =JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataCadastro;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataApreensao;

    @OneToMany(mappedBy="veiculo",cascade=CascadeType.ALL)
    private List<Atuacao> atuacoes = new ArrayList<>();

    public Atuacao adicionarAtuacao(Atuacao atuacao){
        atuacao.setDataOcorrencia(OffsetDateTime.now());
        atuacao.setVeiculo(this);
        getAtuacoes().add(atuacao);
        return atuacao;
    }


    public void apreender(){
        if(estaApreendido()){
                throw new NegocioException("Veículo já se encontra aprendido");
        }
        setStatus(StatusVeiculo.APREENDIDO);
        setDataApreensao(OffsetDateTime.now());
    }

    public void removerApreensao(){
        if (naoEstaAprendido()){
            throw  new NegocioException("Veiculo não está aprendido");
        }
        setStatus(StatusVeiculo.REGULAR);
        setDataApreensao(null);

    }


    public boolean estaApreendido(){
        return StatusVeiculo.APREENDIDO.equals(getStatus());
    }

    public boolean naoEstaAprendido(){
        return !estaApreendido();
    }
}
