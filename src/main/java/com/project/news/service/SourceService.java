package com.project.news.service;

import com.project.news.model.Source;
import com.project.news.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {

    @Autowired
    SourceRepository sourceRepository;

    public Page<Source> getall(Pageable pageable) {
        return sourceRepository.findAll(pageable);
    }
}
