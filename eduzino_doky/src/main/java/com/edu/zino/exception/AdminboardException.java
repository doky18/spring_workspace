package com.edu.zino.exception;

public class AdminboardException extends RuntimeException{
	
	public AdminboardException(String msg) {
		super(msg);
	}
	
	public AdminboardException(String msg,Throwable e) {
		super(msg,e);
	}
}
