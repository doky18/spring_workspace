package com.edu.springboard.exception;

public class PhotoException extends RuntimeException{
	public PhotoException(String msg) {
		super(msg);
	}
	
	public PhotoException(String msg, Throwable e) {
		super(msg, e);
	}
}
