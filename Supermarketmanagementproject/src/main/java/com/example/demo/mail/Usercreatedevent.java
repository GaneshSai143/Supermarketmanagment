package com.example.demo.mail;

import org.springframework.context.ApplicationEvent;

public class Usercreatedevent extends ApplicationEvent {
    public Usercreatedevent(Object source) {
        super(source);
    }
}
