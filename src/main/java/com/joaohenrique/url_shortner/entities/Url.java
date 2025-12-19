package com.joaohenrique.url_shortner.entities;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collation = "URL's")
public class Url {

    @Id
    private String id;

    private String code;

    private String originalURL;

    private String userID;

    private boolean active = true;

    private Instant createdDate;

    private Instant expiryDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = Instant.now();
    }
}
