package com.thanawis.kbtgclassnet.assignment01.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity handleUnAuthorized(UnAuthorizedException unAuthorizedException){
        return new ResponseEntity(unAuthorizedException.getMessage(),HttpStatus.UNAUTHORIZED);
    }
}
