package com.subrutin.catalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookCreateRequestDTO implements Serializable {

    @NotBlank
    private String bookTitle;

    @NotEmpty
    private List<String> authorIdList;

    @NotEmpty
    private List<String> categoryList;

    @NotBlank
    private String publisherId;

    @JsonProperty("synopsis")
    private String description;

}
