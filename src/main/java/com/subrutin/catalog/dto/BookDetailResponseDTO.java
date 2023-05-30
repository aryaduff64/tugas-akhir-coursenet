package com.subrutin.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDetailResponseDTO implements Serializable {

    private String bookId;

    private List<AuthorResponseDTO> authors;

    private List<CategoryListResponseDTO> categories;

    private PublisherResponseDTO publisher;

    private String bookTitle;

    private String bookDescription;
}
