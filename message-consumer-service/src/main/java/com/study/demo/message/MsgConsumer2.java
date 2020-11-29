package com.study.demo.message;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;


@EnableBinding(Sink.class)
@Service
public class MsgConsumer2 {

    @StreamListener(Sink.INPUT)
    public void test(Message<String> message,
                     @Header(AmqpHeaders.CHANNEL) Channel channel,
                     @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) {

        String payload = message.getPayload();
        System.out.println("consumer:  " + payload);

        try {
            channel.basicAck(deliveryTag, false);//手动确认
        } catch (Exception ex) {
            //记录日志
        }

    }
}
