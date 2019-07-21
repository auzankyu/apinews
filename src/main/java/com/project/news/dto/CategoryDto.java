package com.project.news.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "categories")
public class CategoryDto {

    private Long id;
    @JsonProperty("name")
    private String categoryName;
}
