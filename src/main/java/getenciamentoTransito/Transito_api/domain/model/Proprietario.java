package getenciamentoTransito.Transito_api.domain.model;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonPropertyOrder("id")
@Entity


public class Proprietario {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
