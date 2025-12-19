package com.joaohenrique.url_shortner.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface Command<I,O> {
    ResponseEntity<O> execute(I input);
}
