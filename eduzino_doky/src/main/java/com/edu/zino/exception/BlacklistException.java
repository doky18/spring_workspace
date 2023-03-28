package com.edu.zino.exception;

public class BlacklistException extends RuntimeException{
	public BlacklistException(String msg) {
		super(msg);
	}
	
	public BlacklistException(String msg, Throwable e) {
		super(msg, e);
	}
}