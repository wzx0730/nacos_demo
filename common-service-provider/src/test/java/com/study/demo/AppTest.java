package com.study.demo;


import com.study.demo.service.msgBinding.MessageProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    MessageProvider msg;
    @Test
    /**
     * 发送对象
     */
    public void process() {
        GenericMessage<String> stringGenericMessage = new GenericMessage<String>(UUID.randomUUID().toString());

        msg.send();


    }
}
