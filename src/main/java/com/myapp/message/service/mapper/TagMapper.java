package com.myapp.message.service.mapper;


import com.myapp.message.domain.*;
import com.myapp.message.service.dto.TagDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Tag} and its DTO {@link TagDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TagMapper extends EntityMapper<TagDTO, Tag> {


    @Mapping(target = "entries", ignore = true)
    @Mapping(target = "removeEntry", ignore = true)
    Tag toEntity(TagDTO tagDTO);

    default Tag fromId(String id) {
        if (id == null) {
            return null;
        }
        Tag tag = new Tag();
        tag.setId(id);
        return tag;
    }
}
