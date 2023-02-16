package com.edu.springboard.exception;

public class NoticeException extends RuntimeException{
	public NoticeException(String msg) {
		super(msg);
	}
	
	public NoticeException(String msg, Throwable e) {
		super(msg, e);
	}
}
