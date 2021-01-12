package com.myapp.message.repository;

import com.myapp.message.domain.Entry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Entry entity.
 */
@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {

    @Query("{}")
    Page<Entry> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Entry> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Entry> findOneWithEagerRelationships(String id);
}
