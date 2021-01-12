package com.myapp.message.service.impl;

import com.myapp.message.service.TagService;
import com.myapp.message.domain.Tag;
import com.myapp.message.repository.TagRepository;
import com.myapp.message.service.dto.TagDTO;
import com.myapp.message.service.mapper.TagMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Tag}.
 */
@Service
public class TagServiceImpl implements TagService {

    private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public TagDTO save(TagDTO tagDTO) {
        log.debug("Request to save Tag : {}", tagDTO);
        Tag tag = tagMapper.toEntity(tagDTO);
        tag = tagRepository.save(tag);
        return tagMapper.toDto(tag);
    }

    @Override
    public Page<TagDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tags");
        return tagRepository.findAll(pageable)
            .map(tagMapper::toDto);
    }


    @Override
    public Optional<TagDTO> findOne(String id) {
        log.debug("Request to get Tag : {}", id);
        return tagRepository.findById(id)
            .map(tagMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Tag : {}", id);
        tagRepository.deleteById(id);
    }
}
