package com.edu.springshop.exception;

public class HashException extends RuntimeException{
	public HashException(String msg) {
		super(msg);
	}
	
	public HashException(String msg, Throwable e) {
		super(msg, e);
	}
}
