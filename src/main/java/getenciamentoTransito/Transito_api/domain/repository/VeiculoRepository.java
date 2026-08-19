package getenciamentoTransito.Transito_api.domain.repository;

import getenciamentoTransito.Transito_api.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByPlaca(String placa);
}
