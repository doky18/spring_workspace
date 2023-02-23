package com.edu.springshop.exception;

public class ProductException extends RuntimeException{
	public ProductException(String msg) {
		super(msg);
	}
	
	public ProductException(String msg, Throwable e) {
		super(msg, e);
	}
}
