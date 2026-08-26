package getenciamentoTransito.Transito_api.ExceptionHandler;

import getenciamentoTransito.Transito_api.domain.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }


}
