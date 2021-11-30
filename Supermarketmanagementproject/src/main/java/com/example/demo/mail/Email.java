package com.example.demo.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Email {
 private   String toEmail;
 private   String subject;
 private    String content;
    //String template;
    Map<String, Object> model;
   // Map<String, String> images;
}