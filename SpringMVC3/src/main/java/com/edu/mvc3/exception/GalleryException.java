package com.edu.mvc3.exception;

public class GalleryException extends RuntimeException{
	public GalleryException(String msg) {
		super(msg);
	}
	
	public GalleryException(Throwable e) {
		super(e);
	}
	
	public GalleryException(String msg, Throwable e) {
		super(msg, e);
	}
}
