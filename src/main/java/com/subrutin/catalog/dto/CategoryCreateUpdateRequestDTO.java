package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryCreateUpdateRequestDTO implements Serializable {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;
}
