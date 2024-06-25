package dev.eyaz.exmpl.service.read.exception;

public class LinkNotFoundException extends RuntimeException{

    public LinkNotFoundException(String message) {
        super(message);
    }
}
