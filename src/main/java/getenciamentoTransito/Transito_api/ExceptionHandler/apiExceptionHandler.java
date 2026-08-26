package getenciamentoTransito.Transito_api.ExceptionHandler;

import getenciamentoTransito.Transito_api.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestControllerAdvice
public class apiExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;



    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("um ou mais campos estão vazios");

      Map<String,String> fields=  ex.getBindingResult().getAllErrors().stream()
              .collect(Collectors.toMap(objcetError
                      ->((FieldError)objcetError).getField(), objectError->messageSource.getMessage(objectError, LocaleContextHolder.getLocale())));

      problemDetail.setProperty("invalid fields",fields);

        return handleExceptionInternal(ex,problemDetail,headers,status,request);
    }

    @ExceptionHandler(NegocioException.class)
    public ProblemDetail handleNegocio (NegocioException e){
    ProblemDetail problemDetail= ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle(e.getMessage());
    return problemDetail;
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ProblemDetail handEntidadeNaoEncontrada (NegocioException e){
        ProblemDetail problemDetail= ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle(e.getMessage());
        return problemDetail;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrity(DataIntegrityViolationException e ){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("recurso está em uso");
        return problemDetail;
    }
}
