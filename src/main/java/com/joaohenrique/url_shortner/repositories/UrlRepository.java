package com.joaohenrique.url_shortner.repositories;

import com.joaohenrique.url_shortner.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<Url, Long> {

    Optional<Url> findByCode(String code);
}
