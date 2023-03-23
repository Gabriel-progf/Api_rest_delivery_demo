package com.teste.demo.services.exceptions;


public class DataBaseException extends RuntimeException {

    public DataBaseException(Object id){
        super("Not valid id: " + id);
    }
    
}
