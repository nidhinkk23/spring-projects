package com.tyss.productbootapi.exception;

public class NameAlreadyExistException extends RuntimeException {
	
	public NameAlreadyExistException(String msg) {
		super(msg);
	}
}
