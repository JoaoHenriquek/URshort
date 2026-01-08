package com.joaohenrique.url_shortner.services;

import com.joaohenrique.url_shortner.entities.Url;
import com.joaohenrique.url_shortner.repositories.UrlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RedirectService {

    private final UrlRepository urlRepository;

    public RedirectService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ResponseEntity<Void> redirectTo(String code) {
        Url url = urlRepository.findByCode(code)
                .orElse(null);

        if (url == null || url.getExpiryDate().isBefore(Instant.now())) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
