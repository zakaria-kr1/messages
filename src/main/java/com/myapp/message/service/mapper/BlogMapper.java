package com.myapp.message.service.mapper;


import com.myapp.message.domain.*;
import com.myapp.message.service.dto.BlogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Blog} and its DTO {@link BlogDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    BlogDTO toDto(Blog blog);

    @Mapping(source = "userId", target = "user")
    Blog toEntity(BlogDTO blogDTO);

    default Blog fromId(String id) {
        if (id == null) {
            return null;
        }
        Blog blog = new Blog();
        blog.setId(id);
        return blog;
    }
}
