package com.edu.springboard.exception;

public class ReBoardException extends RuntimeException{
	public ReBoardException(String msg) {
		super(msg);
	}
	
	public ReBoardException(String msg, Throwable e) {
		super(msg, e);
	}
}
