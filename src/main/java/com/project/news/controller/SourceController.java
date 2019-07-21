package com.project.news.controller;

import com.project.news.dto.ArticleDto;
import com.project.news.dto.SourceDto;
import com.project.news.model.Article;
import com.project.news.model.Source;
import com.project.news.service.SourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sources")
public class SourceController {

    @Autowired
    SourceService sourceService;

    @Autowired
    ModelMapper modelMapper;

    SourceDto sourceDto;

//    @GetMapping("")
//    public List<Source> getAll() {
//        List<Source> sources = sourceService.getall();
//        return sources.stream().map(source -> convert(source)).collect(Collectors.toList());
//    }

    @GetMapping("")
    public ResponseEntity<PagedResources<SourceDto>> all(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Source> source = sourceService.getall(pageable);
        Page<SourceDto> sources = source.map(this::convert);
        return new ResponseEntity<>(assembler.toResource(sources), HttpStatus.OK);
    }

    private SourceDto convert(Source source) {
        sourceDto = modelMapper.map(source, SourceDto.class);
        return sourceDto;
    }
}
