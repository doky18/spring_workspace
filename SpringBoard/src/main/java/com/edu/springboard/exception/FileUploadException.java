package com.edu.springboard.exception;

public class FileUploadException extends RuntimeException{
	public FileUploadException(String msg) {
		super(msg);
	}
	
	public FileUploadException(String msg, Throwable e) {
		super(msg, e);
	}
}
