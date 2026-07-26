package com.caio.real_time_vote_system.infraestructure.exception;

public class IdUserNotFoundException extends RuntimeException{

    public IdUserNotFoundException(String message) {
        super(message);
    }
}
