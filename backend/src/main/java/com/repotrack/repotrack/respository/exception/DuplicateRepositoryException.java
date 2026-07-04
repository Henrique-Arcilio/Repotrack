package com.repotrack.repotrack.respository.exception;

public class DuplicateRepositoryException extends RuntimeException {
    public DuplicateRepositoryException(String message) {
        super(message);
    }
}
