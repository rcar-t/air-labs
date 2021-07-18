package com.rhonda.AirLabsChallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rhonda.AirLabsChallenge.dto.Response;
import com.rhonda.AirLabsChallenge.dto.Response.Status;
import com.rhonda.AirLabsChallenge.dto.ResponseError;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity handleNotFoundException(Exception ex, WebRequest request) {
		ResponseError error = new ResponseError(ex.getMessage());
		Response response = new Response(Status.HTTP_ERROR, error);
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity handleAll(Exception ex, WebRequest request) {
		ResponseError error = new ResponseError(ex.getMessage());
		Response response = new Response(Status.HTTP_ERROR, error);
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
