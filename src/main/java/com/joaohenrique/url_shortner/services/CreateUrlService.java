package com.joaohenrique.url_shortner.services;

import com.joaohenrique.url_shortner.controller.request.UrlCreateRequest;
import com.joaohenrique.url_shortner.controller.response.UrlCreateResponse;
import com.joaohenrique.url_shortner.entities.Url;
import com.joaohenrique.url_shortner.entities.User;
import com.joaohenrique.url_shortner.repositories.UrlRepository;
import com.joaohenrique.url_shortner.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class CreateUrlService {
    private final UrlRepository urlRepository;
    private final UserRepository userRepository;

    public CreateUrlService(UrlRepository urlRepository, UserRepository userRepository) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<UrlCreateResponse> execute(UrlCreateRequest urlCreateRequest) {
        String code;
        Instant date;
        if (urlCreateRequest.code().isEmpty()) {
            code = generateCode();
        }else{
            code = urlCreateRequest.code();
        }

        if(urlRepository.findByCode(code).isPresent()){
            throw new IllegalArgumentException("code already exists");
        }

        if(urlCreateRequest.expiryDate() == null){
            date = Instant.now().plus(7, ChronoUnit.DAYS);
        }else {
            date = urlCreateRequest.expiryDate();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userID = authentication.getName();
        User user = userRepository.findById(userID).orElse(null);
        user.setUrls(user.getUrls()+1);
        userRepository.save(user);


        Url newUrl = new Url();
        newUrl.setCode(code);
        newUrl.setOriginalURL(urlCreateRequest.url());
        newUrl.setUserID(userID);
        newUrl.setExpiryDate(date);

        urlRepository.save(newUrl);

        String shortUrl = "http://localhost:8080/" + newUrl.getCode();

        return ResponseEntity.ok(new UrlCreateResponse("URL Criada: ",shortUrl ));

    }

    private String generateCode() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 8);
    }
}
