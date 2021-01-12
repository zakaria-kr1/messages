package com.myapp.message.service.impl;

import com.myapp.message.service.EntryService;
import com.myapp.message.domain.Entry;
import com.myapp.message.repository.EntryRepository;
import com.myapp.message.service.dto.EntryDTO;
import com.myapp.message.service.mapper.EntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Entry}.
 */
@Service
public class EntryServiceImpl implements EntryService {

    private final Logger log = LoggerFactory.getLogger(EntryServiceImpl.class);

    private final EntryRepository entryRepository;

    private final EntryMapper entryMapper;

    public EntryServiceImpl(EntryRepository entryRepository, EntryMapper entryMapper) {
        this.entryRepository = entryRepository;
        this.entryMapper = entryMapper;
    }

    @Override
    public EntryDTO save(EntryDTO entryDTO) {
        log.debug("Request to save Entry : {}", entryDTO);
        Entry entry = entryMapper.toEntity(entryDTO);
        entry = entryRepository.save(entry);
        return entryMapper.toDto(entry);
    }

    @Override
    public Page<EntryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Entries");
        return entryRepository.findAll(pageable)
            .map(entryMapper::toDto);
    }


    public Page<EntryDTO> findAllWithEagerRelationships(Pageable pageable) {
        return entryRepository.findAllWithEagerRelationships(pageable).map(entryMapper::toDto);
    }

    @Override
    public Optional<EntryDTO> findOne(String id) {
        log.debug("Request to get Entry : {}", id);
        return entryRepository.findOneWithEagerRelationships(id)
            .map(entryMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Entry : {}", id);
        entryRepository.deleteById(id);
    }
}
