package dev.eyaz.exmpl.service.write.dto.response;

import java.time.LocalDateTime;

public class OperationCreateResponse {

    private LocalDateTime creationTime;
    private String link;

    public OperationCreateResponse() {
    }

    public OperationCreateResponse(LocalDateTime creationTime, String link) {
        this.creationTime = creationTime;
        this.link = link;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
