package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.ValidationErr;

import java.util.List;

public interface HelperFunctions {
    List<ValidationErr> getConstraintViolations(Throwable cause);
}
