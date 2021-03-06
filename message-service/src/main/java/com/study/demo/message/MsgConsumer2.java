package com.study.demo.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
@Service
public class MsgConsumer2 {

    @StreamListener(Sink.INPUT)
    public void test(Message<String> message){
        String payload = message.getPayload();
        System.out.println("消费者2"+payload);
    }
}
