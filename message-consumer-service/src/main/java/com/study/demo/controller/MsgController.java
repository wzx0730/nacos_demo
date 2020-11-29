package com.study.demo.controller;


import com.study.demo.message.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @Autowired
    MessageProvider messageProvider;

    @RequestMapping("/send/{message}")
    public String send(@PathVariable("message") String msg){
        messageProvider.send(msg);
        return "success";
    }
}
