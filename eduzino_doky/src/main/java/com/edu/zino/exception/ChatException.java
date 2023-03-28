package com.edu.zino.exception;

public class ChatException extends RuntimeException{
	
	public ChatException(String msg) {
		super(msg);
	}
	public ChatException(String msg, Throwable e) {
		super(msg,e);
	}
}
