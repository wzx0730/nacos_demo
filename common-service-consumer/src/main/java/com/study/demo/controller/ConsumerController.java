package com.study.demo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.study.demo.OrderDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class ConsumerController {



    @Value("${username}")
    private String username2;

    @Value("${password}")
    private String password;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/hello/{param}")
    public String sayHello(@PathVariable("param") String param) {

        String s = restTemplate.getForObject("http://service-provider-9001/provider/hello/" + param, String.class);
        return s;
    }

    @RequestMapping("/msg/send/{message}")
    public String send(@PathVariable("message") String message) {
        String s = restTemplate.getForObject("http://message-service8083/send/" + message, String.class);
        return s;
    }

    @RequestMapping("/order/{orderId}")
    public OrderDo getOrder(@PathVariable("orderId") String id) {
        OrderDo s = restTemplate.getForObject("http://service-provider-9001/order/" + id, OrderDo.class);
        return s;
    }

    @RequestMapping("/payment/pay/{paymentId}")
    public Boolean execPayment(@PathVariable("paymentId") Integer id) {


        return null;

    }

}
