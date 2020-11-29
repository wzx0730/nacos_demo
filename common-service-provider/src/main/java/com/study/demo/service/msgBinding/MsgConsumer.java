package com.study.demo.service.msgBinding;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
@Service
public class MsgConsumer {

    @StreamListener(Sink.INPUT)
    public void test(Message<String> message){
        String payload = message.getPayload();
        System.out.println(payload);
    }
}
