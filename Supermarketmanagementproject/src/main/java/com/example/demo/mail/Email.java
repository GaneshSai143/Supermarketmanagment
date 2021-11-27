package com.example.demo.mail;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class Email {
 private   String toEmail;
 private   String subject;
 private    String content;
    //String template;
    Map<String, Object> model;
   // Map<String, String> images;
}