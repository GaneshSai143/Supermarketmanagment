package com.example.demo.entity.dto;




import java.util.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.controller.Emailvalid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

public class Userdto {


	private int id;
	@NotEmpty( message = "firstname name should have")
    private String firstName;
	@NotEmpty( message = "last name should have ")
    private String lastName;
	//@NotEmpty(message = "password should have")
    private String username;
    private String password;
	
	@NotBlank(message="the email was required")
	@Pattern(regexp ="^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="mail id is not valid")
	   @Email(message = "Please provide valid email address")
    private String emailId;
	//@NotEmpty(message="role was not empty")
	//@NotNull
    private String roletype;
   
    
}
