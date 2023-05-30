package com.subrutin.catalog.web;

import com.subrutin.catalog.dto.HelloMessageResponseDTO;
import com.subrutin.catalog.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResources {

    private GreetingService greetingService;

    public HelloResources(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public ResponseEntity<HelloMessageResponseDTO> helloWorld() {
        HelloMessageResponseDTO dto = new HelloMessageResponseDTO();
        dto.setMessage(greetingService.sayGreeting());
        return ResponseEntity.accepted().body(dto);
    }
}
