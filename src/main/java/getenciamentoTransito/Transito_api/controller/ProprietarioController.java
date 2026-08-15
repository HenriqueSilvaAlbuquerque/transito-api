package getenciamentoTransito.Transito_api.controller;

import getenciamentoTransito.Transito_api.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar(){
        var proprietario1=new Proprietario();
        proprietario1.setId(1l);
        proprietario1.setNome("caio");
        proprietario1.setTelefone("1299784146");
        proprietario1.setEmail("jouinazai@kia");

        var proprietario2=new Proprietario();
        proprietario2.setId(2l);
        proprietario2.setNome("pedro");
        proprietario2.setTelefone("7879789974115");
        proprietario2.setEmail("fhghagaag@kia");

        return Arrays.asList(proprietario1,proprietario2);


    }

}
