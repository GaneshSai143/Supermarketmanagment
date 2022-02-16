package com.example.demo.error;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.UserRepository;

public class UniqueValidator implements ConstraintValidator<Uniquefield, String> {

	@Autowired
	UserRepository urepo;
	
	 Logger logger=LoggerFactory.getLogger(Uniquefield.class);
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		logger.info("is valid");
		return !urepo.findByUsername(value).isEnabled();
	}

	
	}


