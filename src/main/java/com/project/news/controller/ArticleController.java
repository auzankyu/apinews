package com.project.news.controller;

import com.project.news.dto.ArticleDto;
import com.project.news.model.Article;
import com.project.news.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ModelMapper modelMapper;

    ArticleDto articleDto;

    @GetMapping("")
    public ResponseEntity<PagedResources<ArticleDto>> all(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Article> article = articleService.getAll(pageable);
        Page<ArticleDto> articles = article.map(this::convert);
        return new ResponseEntity<>(assembler.toResource(articles), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> find(@PathVariable(value = "id") Long id) {
        articleDto = convert(articleService.getById(id));
        return new ResponseEntity<>(articleDto, HttpStatus.OK);
    }

    private ArticleDto convert(Article article) {
        articleDto = modelMapper.map(article, ArticleDto.class);
        return articleDto;
    }
}
