package com.edu.zino.exception;

public class SnsNameException extends RuntimeException{
	public SnsNameException(String msg) {
		super(msg);
	}
	
	public SnsNameException(String msg, Throwable e) {
		super(msg, e);
	}
}