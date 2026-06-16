package com.jamal.pfe.backend.common.exception;

public class InvalidStatutTransitionException extends RuntimeException {
    public InvalidStatutTransitionException(String message) {
        super(message);
    }
}