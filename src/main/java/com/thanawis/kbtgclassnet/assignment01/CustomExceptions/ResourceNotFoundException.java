package com.thanawis.kbtgclassnet.assignment01.CustomExceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
