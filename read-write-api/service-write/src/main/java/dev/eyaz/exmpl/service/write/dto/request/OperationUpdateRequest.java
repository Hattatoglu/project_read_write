package dev.eyaz.exmpl.service.write.dto.request;

public class OperationUpdateRequest {

    private String link;
    private int expiration;
    private String message;

    public OperationUpdateRequest() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
