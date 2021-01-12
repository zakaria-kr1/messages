package com.myapp.message.service.impl;

import com.myapp.message.service.BlogService;
import com.myapp.message.domain.Blog;
import com.myapp.message.repository.BlogRepository;
import com.myapp.message.service.dto.BlogDTO;
import com.myapp.message.service.mapper.BlogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Blog}.
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);

    private final BlogRepository blogRepository;

    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public BlogDTO save(BlogDTO blogDTO) {
        log.debug("Request to save Blog : {}", blogDTO);
        Blog blog = blogMapper.toEntity(blogDTO);
        blog = blogRepository.save(blog);
        return blogMapper.toDto(blog);
    }

    @Override
    public List<BlogDTO> findAll() {
        log.debug("Request to get all Blogs");
        return blogRepository.findAll().stream()
            .map(blogMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    public Optional<BlogDTO> findOne(String id) {
        log.debug("Request to get Blog : {}", id);
        return blogRepository.findById(id)
            .map(blogMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Blog : {}", id);
        blogRepository.deleteById(id);
    }
}
