package com.sulimann.dimensa.controllers.controllerexceptionhandler;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

import com.sulimann.dimensa.constants.ErrorMessage;
import com.sulimann.dimensa.exceptions.ResourceNotFoundException;
import com.sulimann.dimensa.utils.httpresponse.ErroResponse;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponse> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroResponse error = new ErroResponse(LocalDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO error = new ValidationErrorDTO(LocalDateTime.now(), status.value(), "Dados inválidos", request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()){
            error.addError(new FieldMessageDTO(f.getField(), f.getDefaultMessage()));
        }
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErroResponse error = new ErroResponse(LocalDateTime.now(), status.value(), ErrorMessage.ERRO_INTERNO, request.getRequestURI());
        e.printStackTrace();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<ErroResponse> handleHttpStatusCodeException(HttpStatusCodeException e, HttpServletRequest request) {
        HttpStatusCode status = e.getStatusCode();
        ErroResponse error = new ErroResponse(LocalDateTime.now(), status.value(), e.getResponseBodyAsString(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ErroResponse> handleResourceAccessException(ResourceAccessException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        ErroResponse error = new ErroResponse(LocalDateTime.now(), status.value(), "Serviço indisponível: " + e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
