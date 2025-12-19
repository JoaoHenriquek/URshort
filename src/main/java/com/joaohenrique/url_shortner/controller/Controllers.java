package com.joaohenrique.url_shortner.controller;

import com.joaohenrique.url_shortner.controller.request.LoginRequest;
import com.joaohenrique.url_shortner.controller.request.RegisterRequest;
import com.joaohenrique.url_shortner.controller.request.UrlCreateRequest;
import com.joaohenrique.url_shortner.controller.response.LoginResponse;
import com.joaohenrique.url_shortner.controller.response.RegisterResponse;
import com.joaohenrique.url_shortner.controller.response.UrlCreateResponse;
import com.joaohenrique.url_shortner.services.CreateUrlService;
import com.joaohenrique.url_shortner.services.LoginService;
import com.joaohenrique.url_shortner.services.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    private RegisterService registerService;
    private LoginService loginService;
    private CreateUrlService createUrlService;

    public Controllers(RegisterService registerService,  LoginService loginService,
                       CreateUrlService createUrlService) {
        this.registerService = registerService;
        this.loginService = loginService;
        this.createUrlService = createUrlService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        return registerService.execute(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return loginService.execute(loginRequest);
    }

    @PostMapping("/create-url")
    public ResponseEntity<UrlCreateResponse> createUrl(@RequestBody UrlCreateRequest urlCreateRequest) {
        return createUrlService.execute(urlCreateRequest);
    }
}
