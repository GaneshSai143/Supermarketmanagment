package com.example.demo.controller;


import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.error.Validationerrorresponse;
import com.example.demo.error.Violation;
import com.example.demo.exception.ResourceNotFoundException;


@ControllerAdvice
public class Validationcontroller extends ResponseEntityExceptionHandler{
	
	/* @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final List<String> errors = new ArrayList<String>();
	        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
	            errors.add(error.getField() + ": " + error.getDefaultMessage());
	        }
	        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	        }
	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	    }

	    @Override
	    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final List<String> errors = new ArrayList<String>();
	        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
	            errors.add(error.getField() + ": " + error.getDefaultMessage());
	        }
	        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	        }
	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	    }

	    @Override
	    protected ResponseEntity<Object> handleTypeMismatch(final TypeMismatchException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final String error = ex.getValue() + " value for " + ex.getPropertyName() + " should be of type " + ex.getRequiredType();

	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    @Override
	    protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final String error = ex.getRequestPartName() + " part is missing";
	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    @Override
	    protected ResponseEntity<Object> handleMissingServletRequestParameter(final MissingServletRequestParameterException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final String error = ex.getParameterName() + " parameter is missing";
	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    //

	    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

	        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }
	    
	    @ExceptionHandler({ ConstraintViolationException.class })
	    public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	       List<String> details = new ArrayList<>();
	       // Validationerrorresponse errors= new Validationerrorresponse();
	        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        	details.addAll((Collection<? extends String>) new Violation(violation.getPropertyPath().toString(), violation.getMessage(), violation.toString(), details));
	        			
	        }
	        Violation v= new Violation("Validation Failed", PAGE_NOT_FOUND_LOG_CATEGORY, PAGE_NOT_FOUND_LOG_CATEGORY,details);
	      //  final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	        return new ResponseEntity<Object>(v, HttpStatus.BAD_REQUEST);
	    }
	  /*  @ExceptionHandler(ConstraintViolationException.class)
		  @ResponseStatus(HttpStatus.BAD_REQUEST)
		  @ResponseBody
		  ValidationErrorResponse onConstraintValidationException(
		      ConstraintViolationException e) {
		    ValidationErrorResponse error = new ValidationErrorResponse();
		    for (ConstraintViolation violation : e.getConstraintViolations()) {
		      error.getViolations().add(
		        new Violation(violation.getPropertyPath().toString(), violation.getMessage(), violation.toString()));

	    // 404

	    @Override
	    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

	        final ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    // 405

	    @Override
	    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(final HttpRequestMethodNotSupportedException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final StringBuilder builder = new StringBuilder();
	        builder.append(ex.getMethod());
	        builder.append(" method is not supported for this request. Supported methods are ");
	        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

	        final ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    // 415

	    @Override
	    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(final HttpMediaTypeNotSupportedException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        //
	        final StringBuilder builder = new StringBuilder();
	        
	        builder.append(ex.getContentType());
	        builder.append(" media type is not supported. Supported media types are ");
	        ex.getSupportedMediaTypes().forEach(t -> builder.append(t + " "));
            
	        final ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getLocalizedMessage(), builder.substring(0, builder.length() - 2));
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }

	    // 500

	    @ExceptionHandler({ Exception.class })
	    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request) {
	        logger.info(ex.getClass().getName());
	        logger.error("error", ex);
	        //
	        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
	        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	    }*/
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        Violation error = new Violation("Server Error", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        Violation error = new Violation("Record Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        Violation error = new Violation("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}