package com.nttdata.practicadevara.projapp.shared.dto;

public class BackendException extends Exception {
    
    public BackendException() {
        super();
    }

    public BackendException(String message) {
        super(message);
    }
}
