package com.myapp.message.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.myapp.message.web.rest.TestUtil;

public class MessageTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Message.class);
        Message message1 = new Message();
        message1.setId("id1");
        Message message2 = new Message();
        message2.setId(message1.getId());
        assertThat(message1).isEqualTo(message2);
        message2.setId("id2");
        assertThat(message1).isNotEqualTo(message2);
        message1.setId(null);
        assertThat(message1).isNotEqualTo(message2);
    }
}
