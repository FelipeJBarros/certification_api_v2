package com.flpbrrs.certification.infra;

import com.flpbrrs.certification.infra.dtos.FieldValidationErrorDTO;
import com.flpbrrs.certification.infra.dtos.NotReadableDTO;
import com.flpbrrs.certification.infra.dtos.RequestExceptionHandlerDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RequestExceptionHandlerDTO> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        var fieldWithErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getField)
                .distinct()
                .toList();

        var errorList = fieldWithErrors.stream().map(field -> {
            var fieldErrors = ex.getBindingResult().getFieldErrors(field).stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();

            return FieldValidationErrorDTO.builder()
                    .field(field)
                    .messages(fieldErrors)
                    .build();
        }).toList();

        var response = RequestExceptionHandlerDTO.builder()
                .title("Validation field error")
                .errors(errorList)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<NotReadableDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        var notReadableError = NotReadableDTO.builder()
                .message("Verify your JSON. Malformed request.")
                .cause(ex.getMessage().split(":")[0])
                .build();
        return ResponseEntity.badRequest().body(notReadableError);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<NotReadableDTO> handleMissingRequestParameter(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(
                NotReadableDTO.builder()
                        .message("Verify your request. Malformed request.")
                        .cause(ex.getMessage())
                        .build()
        );
    }
}
