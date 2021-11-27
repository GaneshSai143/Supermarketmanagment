package com.example.demo.mail;

import lombok.RequiredArgsConstructor;



import lombok.var;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class Usercreatedlistner {


    private final Emailserviceimpl emailService;

    @EventListener
    @Async
    public void onUserCreated(Usercreatedevent event) throws Exception {
        final var user = (User) event.getSource();

        Map<String, Object> model = new HashMap<>();
        model.put("reservation", user);
     

       var mail = new Email.EmailBuilder()
                .subject("Welcome to Super market Management System Program")
                .toEmail(user.getEmailid())
                .content("You were added by " +"Username :"+user.getUsername() +"\n"+ "password :"+user.getPassword())
                .model(model)
                .build();

       emailService.sendEmail(mail);
    }
}