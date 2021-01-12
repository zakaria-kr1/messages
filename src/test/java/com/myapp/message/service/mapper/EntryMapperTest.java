package com.myapp.message.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EntryMapperTest {

    private EntryMapper entryMapper;

    @BeforeEach
    public void setUp() {
        entryMapper = new EntryMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(entryMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(entryMapper.fromId(null)).isNull();
    }
}
