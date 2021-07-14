package com.rhonda.AirLabsChallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rhonda.AirLabsChallenge.dto.Response;
import com.rhonda.AirLabsChallenge.dto.Response.Status;
import com.rhonda.AirLabsChallenge.dto.ResponseError;

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler({Exception.class})
	public ResponseEntity handleAll(Exception ex, WebRequest request) {
		ResponseError error = new ResponseError(ex.getMessage());
		Response response = new Response(Status.HTTP_ERROR, error);
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
