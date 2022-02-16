package com.example.demo.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User1 {
	
	private int id;
	@NotEmpty( message = "firstname name should have")
    private String firstName;
	@NotEmpty( message = "last name should have ")
    private String lastName;
	
    private String username;
    @NotBlank(message = "password should have")
    private String password;
	
	@NotBlank(message="the email was required")
	@Pattern(regexp ="^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="mail id is not valid")
	   @Email(message = "Please provide valid email address")
    private String emailId;
	//@NotEmpty(message="role was not empty")
	//@NotNull
    private String roletype;

}
