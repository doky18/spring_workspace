package com.edu.springshop.exception;

public class UploadException extends RuntimeException{
	public UploadException(String msg) {
		super(msg);
	}
	
	public UploadException(String msg, Throwable e) {
		super(msg, e);
	}
}
