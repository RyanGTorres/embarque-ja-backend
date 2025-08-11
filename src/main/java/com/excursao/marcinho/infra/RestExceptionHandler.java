package com.excursao.marcinho.infra;

import com.excursao.marcinho.exceptions.BusinessException;
import com.excursao.marcinho.exceptions.badrequest.BadRequestException;
import com.excursao.marcinho.exceptions.conflict.ConflictException;
import com.excursao.marcinho.exceptions.notfound.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestErrorMessage> notFoundException (NotFoundException exception){
        RestErrorMessage tError = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tError);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<RestErrorMessage> conflictException (ConflictException exception){
        RestErrorMessage tError = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(tError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<RestErrorMessage> badRequestException(BadRequestException exception){
        RestErrorMessage tError = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tError);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<RestErrorMessage> businessException(BusinessException exception){
        RestErrorMessage tError = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(tError);
    }

}

