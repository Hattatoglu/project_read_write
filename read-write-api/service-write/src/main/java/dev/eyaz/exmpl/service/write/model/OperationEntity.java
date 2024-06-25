package dev.eyaz.exmpl.service.write.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Operation")
public class OperationEntity {

    @Id
    @SequenceGenerator(name = "op_id_gen", allocationSize = 1)
    @GeneratedValue(generator = "op_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "expiration")
    private int expiration;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "link", length = 255)
    private String link;

    public OperationEntity() {
    }

    public OperationEntity(Long id, int expiration, LocalDateTime created_at, String link) {
        this.id = id;
        this.expiration = expiration;
        this.created_at = created_at;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
