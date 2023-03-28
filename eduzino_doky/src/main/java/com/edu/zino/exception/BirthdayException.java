package com.edu.zino.exception;

public class BirthdayException extends RuntimeException{
	public BirthdayException(String msg) {
		super(msg);
	}
	
	public BirthdayException(String msg, Throwable e) {
		super(msg, e);
	}
}