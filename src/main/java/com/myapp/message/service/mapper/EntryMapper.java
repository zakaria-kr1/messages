package com.myapp.message.service.mapper;


import com.myapp.message.domain.*;
import com.myapp.message.service.dto.EntryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Entry} and its DTO {@link EntryDTO}.
 */
@Mapper(componentModel = "spring", uses = {BlogMapper.class, TagMapper.class})
public interface EntryMapper extends EntityMapper<EntryDTO, Entry> {

    @Mapping(source = "blog.id", target = "blogId")
    @Mapping(source = "blog.name", target = "blogName")
    EntryDTO toDto(Entry entry);

    @Mapping(source = "blogId", target = "blog")
    @Mapping(target = "removeTag", ignore = true)
    Entry toEntity(EntryDTO entryDTO);

    default Entry fromId(String id) {
        if (id == null) {
            return null;
        }
        Entry entry = new Entry();
        entry.setId(id);
        return entry;
    }
}
