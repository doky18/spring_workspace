package com.edu.zino.exception;

public class ProfilePhotoException extends RuntimeException{
	public ProfilePhotoException(String msg) {
		super(msg);
	}
	
	public ProfilePhotoException(String msg, Throwable e) {
		super(msg, e);
	}
}