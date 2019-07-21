package com.project.news.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "sources")
public class SourceDto {
    private Long id;
    private String name;
    private String description;
    private String url;
    private String language;
    private String country;
    private CategoryDto category;
}
