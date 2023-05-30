package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.subrutin.catalog.annotation.LogThisArg;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@LogThisArg
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateRequestDTO implements Serializable {

    @NotBlank
    private String publisherName;

    @NotBlank
    private String companyName;

    private String address;

}
