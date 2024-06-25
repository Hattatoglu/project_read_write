package dev.eyaz.exmpl.service.write.exception;

public class LinkNotFoundException extends RuntimeException{

    public LinkNotFoundException(String message) {
        super(message);
    }
}
