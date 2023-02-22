package com.edu.springshop.exception;

public class CategoryException extends RuntimeException{
	public CategoryException(String msg) {
		super(msg);
	}
	
	public CategoryException(String msg, Throwable e) {
		super(msg, e);
	}
}
