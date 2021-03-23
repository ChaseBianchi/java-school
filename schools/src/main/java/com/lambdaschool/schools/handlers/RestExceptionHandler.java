package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.ErrorData;
import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private HelperFunctions helperFunctions;

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe){
        ErrorData errorData = new ErrorData();

        errorData.setTitle("Resource Not Found");
        errorData.setStatus(HttpStatus.NOT_FOUND.value());
        errorData.setDetail(rnfe.getMessage());
        errorData.setTimestamp(new Date());
        errorData.setDeveloperMessage(rnfe.getClass().getName());
        errorData.setErrors(helperFunctions.getConstraintViolations(rnfe));

        return new ResponseEntity<>(errorData, null, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorData errorData = new ErrorData();

        errorData.setTitle("Rest Internal Exception");
        errorData.setStatus(status.value());
        errorData.setDetail("Found an issue with School: " + ex.getMessage());
        errorData.setTimestamp(new Date());
        errorData.setDeveloperMessage(ex.getClass().getName());
        errorData.setErrors(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorData, headers, status);
    }
}
