package com.tyss.productbootapi.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.productbootapi.dto.ProductResponse;
import com.tyss.productbootapi.exception.NameAlreadyExistException;

@RestControllerAdvice
public class ProductRestControllerAdvice {
	
	@ExceptionHandler(NameAlreadyExistException.class)
	public ProductResponse emailAlreadyExist(NameAlreadyExistException e) {
		ProductResponse response = new ProductResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
