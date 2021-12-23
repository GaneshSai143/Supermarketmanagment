package com.example.demo.error;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;


@XmlRootElement(name = "error")
@Data
@AllArgsConstructor
public class Violation {

	//private String fieldname;
	//private String error;
	private String message;
	private List<String> details;
}
