package com.edu.springboard.exception;

public class GalleryException extends RuntimeException{
	public GalleryException(String msg) {
		super(msg);
	}
	
	public GalleryException(String msg, Throwable e) {
		super(msg, e);
	}
}
