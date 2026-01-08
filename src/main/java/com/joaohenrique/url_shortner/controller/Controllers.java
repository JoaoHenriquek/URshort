package com.joaohenrique.url_shortner.controller;

import com.joaohenrique.url_shortner.controller.request.LoginRequest;
import com.joaohenrique.url_shortner.controller.request.RegisterRequest;
import com.joaohenrique.url_shortner.controller.request.UrlCreateRequest;
import com.joaohenrique.url_shortner.controller.response.LoginResponse;
import com.joaohenrique.url_shortner.controller.response.RegisterResponse;
import com.joaohenrique.url_shortner.controller.response.UrlCreateResponse;
import com.joaohenrique.url_shortner.services.CreateUrlService;
import com.joaohenrique.url_shortner.services.LoginService;
import com.joaohenrique.url_shortner.services.RedirectService;
import com.joaohenrique.url_shortner.services.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controllers {

    private final RegisterService registerService;
    private final LoginService loginService;
    private final CreateUrlService createUrlService;
    private final RedirectService redirectService;


    public Controllers(RegisterService registerService, LoginService loginService,
                       CreateUrlService createUrlService, RedirectService redirectService) {
        this.registerService = registerService;
        this.loginService = loginService;
        this.createUrlService = createUrlService;
        this.redirectService = redirectService;
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

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        return redirectService.redirectTo(code);
    }
}
