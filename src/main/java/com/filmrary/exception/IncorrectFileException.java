package com.filmrary.exception;

public class IncorrectFileException extends ReadWriteException {
    public IncorrectFileException(String message) {
        super(message);
    }
}
