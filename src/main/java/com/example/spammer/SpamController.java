package com.example.spammer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class SpamController {
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private final RestTemplate restTemplate = restTemplateBuilder.build();

    @GetMapping("spam")
    public boolean spam(int times) {
        String url = "http://localhost:8080/move?threshold=60";
        for (int i = 0; i < times; i++) {
            this.restTemplate.getForObject(url, String.class);
        }

        return true;
    }
}
