package com.study.demo.service.msgBinding;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)//定义消息源
@Service
public class IMessageSendProvider implements MessageProvider {

    @Resource
    private Source source;

    @Override
    public void send() {
        MessageBuilder<UUID> uuidMessageBuilder = MessageBuilder.withPayload(UUID.randomUUID());
        source.output().send(uuidMessageBuilder.build());
//        boolean send = messageChannel.send(MessageBuilder.withPayload(UUID.randomUUID().toString()).build());
        System.out.println(uuidMessageBuilder.getPayload());
    }
}