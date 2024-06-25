package dev.eyaz.exmpl.service.read.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.RedisHash;

@Document
public class ObjectEntity {

    @Id
    @Indexed(unique = true)
    @Field("link")
    private String link;
    @Field("message")
    private String message;

    public ObjectEntity() {
    }

    public ObjectEntity(String link, String message) {
        this.link = link;
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
