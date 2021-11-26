package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Email.Email;
import com.example.demo.Email.Emailservice;


@SpringBootApplication
public class SupermarketmanagementprojectApplication {

	
	public static void main(String[] args) {
		//SpringApplication.run(SupermarketmanagementprojectApplication.class, args);
		
		Email mail = new Email();
        mail.setMailFrom("ganeshsaikandregula03@gmail.com");
        mail.setMailTo("ganeshsaikandregula03@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");
 
        ApplicationContext ctx = SpringApplication.run(SupermarketmanagementprojectApplication.class, args);
        Emailservice mailService = (Emailservice) ctx.getBean("mailService");
        mailService.sendEmail(mail);
	}

}
