package com.example.demo.entity.dto;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString

public class Userdto {

	private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailId;
    private List<String> roletype;
}
