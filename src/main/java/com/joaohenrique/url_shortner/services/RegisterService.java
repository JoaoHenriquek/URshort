package com.joaohenrique.url_shortner.services;

import com.joaohenrique.url_shortner.controller.request.RegisterRequest;
import com.joaohenrique.url_shortner.controller.response.RegisterResponse;
import com.joaohenrique.url_shortner.entities.User;
import com.joaohenrique.url_shortner.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<RegisterResponse> execute(RegisterRequest registerRequest){
        if (userRepository.findByEmail(registerRequest.email()).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        User newUser = new User();
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(bCryptPasswordEncoder.encode(registerRequest.password()));
        userRepository.save(newUser);
        return ResponseEntity.ok(new RegisterResponse("User registered successfully"));
    }
}
