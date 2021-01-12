package com.myapp.message.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.myapp.message.web.rest.TestUtil;

public class BlogDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BlogDTO.class);
        BlogDTO blogDTO1 = new BlogDTO();
        blogDTO1.setId("id1");
        BlogDTO blogDTO2 = new BlogDTO();
        assertThat(blogDTO1).isNotEqualTo(blogDTO2);
        blogDTO2.setId(blogDTO1.getId());
        assertThat(blogDTO1).isEqualTo(blogDTO2);
        blogDTO2.setId("id2");
        assertThat(blogDTO1).isNotEqualTo(blogDTO2);
        blogDTO1.setId(null);
        assertThat(blogDTO1).isNotEqualTo(blogDTO2);
    }
}
