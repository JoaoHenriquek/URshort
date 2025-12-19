package com.joaohenrique.url_shortner.services;

import com.joaohenrique.url_shortner.controller.request.LoginRequest;
import com.joaohenrique.url_shortner.controller.response.LoginResponse;
import com.joaohenrique.url_shortner.repositories.UserRepository;
import com.nimbusds.jwt.JWT;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                        JwtEncoder jwtEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtEncoder = jwtEncoder;
    }


    public ResponseEntity<LoginResponse> execute(LoginRequest loginRequest) {
        if(userRepository.findByEmail(loginRequest.email()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var user =  userRepository.findByEmail(loginRequest.email());

        var rawPassword = loginRequest.password();
        var cripPassword = user.get().getPassword();

        boolean permit = bCryptPasswordEncoder.matches(rawPassword, cripPassword);

        if(!permit || !loginRequest.email().equals(user.get().getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        var now = Instant.now();
        var expireTime = 300;
        var token = JwtClaimsSet.builder()
                    .issuer("backend")
                    .subject(String.valueOf(user.get().getId()))
                    .expiresAt(now.plusSeconds(expireTime))
                    .issuedAt(now)
                    .build();
        var tokenValue = jwtEncoder.encode(JwtEncoderParameters.from(token)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(tokenValue));

    }
}
