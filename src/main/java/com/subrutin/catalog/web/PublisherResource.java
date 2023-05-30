package com.subrutin.catalog.web;

import com.subrutin.catalog.annotation.LogThisMethod;
import com.subrutin.catalog.dto.PublisherCreateRequestDTO;
import com.subrutin.catalog.dto.PublisherListResponseDTO;
import com.subrutin.catalog.dto.PublisherUpdateRequestDTO;
import com.subrutin.catalog.dto.ResultPageResponseDTO;
import com.subrutin.catalog.service.PublisherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class PublisherResource {

    private final PublisherService publisherService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/publisher")
    public ResponseEntity<Void> createNewPublisher(@RequestBody @Valid PublisherCreateRequestDTO dto){
        publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).build();

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updatePublisher(@PathVariable String publisherId, @RequestBody @Valid PublisherUpdateRequestDTO dto){
        publisherService.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @LogThisMethod
    @GetMapping("/v1/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> findPublisherList(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "name") String  sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "publisherName", required = false) String publisherName){
        return ResponseEntity.ok().body(publisherService.findPublisherList(pages, limit, sortBy, direction, publisherName));
    }

}
