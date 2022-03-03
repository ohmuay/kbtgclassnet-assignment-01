package com.thanawis.kbtgclassnet.assignment01.CustomExceptions;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException(String messsage){
        super(messsage);
    }
}
