package com.project.news.service;

import com.project.news.model.Article;
import com.project.news.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Page<Article> getAll(Pageable pageable) {

        Page<Article> articles = articleRepository.findAll(pageable);
        return articles;
    }

    public Article getById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }
}
