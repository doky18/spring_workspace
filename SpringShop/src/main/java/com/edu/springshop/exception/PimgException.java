package com.edu.springshop.exception;

public class PimgException extends RuntimeException{
	public PimgException(String msg) {
		super(msg);
	}
	
	public PimgException(String msg, Throwable e) {
		super(msg, e);
	}
}
