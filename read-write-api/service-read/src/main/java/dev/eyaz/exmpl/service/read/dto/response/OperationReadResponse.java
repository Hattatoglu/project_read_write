package dev.eyaz.exmpl.service.read.dto.response;

public class OperationReadResponse {

    private int expiration;
    private String creationTime;
    private String message;

    public OperationReadResponse() {
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
