package com.caio.real_time_vote_system.infraestructure.exception;

public class InvalidStatusException extends RuntimeException{

    public InvalidStatusException(String message) {
        super(message);
    }
}
