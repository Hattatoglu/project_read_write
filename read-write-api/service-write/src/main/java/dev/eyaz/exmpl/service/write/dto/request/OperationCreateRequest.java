package dev.eyaz.exmpl.service.write.dto.request;

public class OperationCreateRequest {

    private int expiration;
    private String message;

    public OperationCreateRequest() {
    }


    public OperationCreateRequest(int expiration, String message) {
        this.expiration = expiration;
        this.message = message;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
