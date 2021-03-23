package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.ValidationErr;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Service(value = "helperFunctions")
public class HelperFunctionsImpl implements HelperFunctions{
    @Override
    public List<ValidationErr> getConstraintViolations(Throwable cause) {
        List<ValidationErr> validationErrList = new ArrayList<>();

        while(cause != null) {

            if (cause instanceof ConstraintViolationException) {
                ConstraintViolationException exception = (ConstraintViolationException) cause;

                ValidationErr validationErr = new ValidationErr();
                validationErr.setFieldname(exception.getMessage());
                validationErr.setMessage(exception.getConstraintName());

                validationErrList.add(validationErr);
            }

            if (cause instanceof MethodArgumentNotValidException) {
                MethodArgumentNotValidException exception = (MethodArgumentNotValidException) cause;

                List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

                for (FieldError fe : fieldErrors) {
                    ValidationErr validationErr = new ValidationErr();

                    validationErr.setFieldname(fe.getField());
                    validationErr.setMessage(fe.getDefaultMessage());

                    validationErrList.add(validationErr);
                }
            }

            cause = cause.getCause();
        }

        return validationErrList;
    }
}
