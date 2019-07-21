package com.project.news.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.project.news.model.Source;
import lombok.Data;

import java.util.Date;

@Data
@JsonRootName(value = "articles")
public class ArticleDto {
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
    private String content;
    private SourceDto sources;
}
