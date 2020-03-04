package com.katkov.app.controller;

import com.katkov.app.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/kafka")
@RestController
public class UserController {

    private static final String topicName="exodus";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/publish/{message}")
    public String sendMessageIntoKafka(@PathVariable("message") String name) {

        kafkaTemplate.send(topicName,new User(name,"ItDepart","150 000"));
        return "publish message kafka";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
