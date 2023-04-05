package com.example.CartSystem.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.CartSystem.CustomException.ResourceNotFoundException;


@ControllerAdvice
public class ResouceNotFoundHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<String> resourceNotFound(ResourceNotFoundException exc,WebRequest request){
  	  return new ResponseEntity<String>(exc.getMessage(),HttpStatus.NOT_FOUND);
  }
}
