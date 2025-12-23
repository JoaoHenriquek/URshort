package com.joaohenrique.url_shortner.controller.request;

import java.time.Instant;

public record UrlCreateRequest(String url, String code, Instant expiryDate) {
}
