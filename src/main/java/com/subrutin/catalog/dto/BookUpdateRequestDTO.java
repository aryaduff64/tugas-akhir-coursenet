package com.subrutin.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookUpdateRequestDTO {

    @NotBlank
    private String bookTitle;

    private String description;
}
