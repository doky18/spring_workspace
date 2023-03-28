package com.edu.zino.exception;

public class WishException extends RuntimeException{
	
	public WishException(String msg) {
		super(msg);
	}
	public WishException(String msg, Throwable e) {
		super(msg,e);
	}
}
