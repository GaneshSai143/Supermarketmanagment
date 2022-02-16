package com.example.demo.exception;




import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.example.demo.error.Validationerrorresponse;
import com.example.demo.error.Violation;


@ControllerAdvice
@RestControllerAdvice
public class Validationcontroller {
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  Validationerrorresponse onConstraintValidationException(
	      ConstraintViolationException e) {
		Validationerrorresponse error = new Validationerrorresponse();
	    for (ConstraintViolation violation : e.getConstraintViolations()) {
	      error.getViolationlist().add(
	        new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
	    }
	    return error;
	  }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  Validationerrorresponse onMethodArgumentNotValidException(
	      MethodArgumentNotValidException e) {
		Validationerrorresponse error = new Validationerrorresponse();
	    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
	      error.getViolationlist().add(
	        new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
	    }
	    return error;
	  }
	


	@ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  public ResourceError duplicateException(
	      ResourceNotFoundException exception
	  ) {
	    /*return ResponseEntity
	        .status(HttpStatus.NOT_FOUND)
	        .body(exception.getMessage());*/
		return new ResourceError( exception.getLocalizedMessage());
	  }
	
	/*//@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
       // logger.info(ex.getClass().getName());
        //
        final StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));
        final ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }*/
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  Validationerrorresponse onmismatch(
			  MethodArgumentTypeMismatchException e) {
		Validationerrorresponse error = new Validationerrorresponse();
	  
	    error.getViolationlist().add(new Violation(e.getMessage(), e.getPropertyName()));
		return error;
		
	  
	  }
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	Validationerrorresponse onnotsupport(HttpRequestMethodNotSupportedException h) {
		Validationerrorresponse error= new Validationerrorresponse();
		error.getViolationlist().add(new Violation(h.getMethod(),h.getMessage()));
		return error;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	Validationerrorresponse onnotreadable(HttpMessageNotReadableException h1)
	{
		Validationerrorresponse error=new Validationerrorresponse();
		error.getViolationlist().add(new Violation(h1.getLocalizedMessage(),h1.getMessage()));
		return error;
	}
	
	
	
		}