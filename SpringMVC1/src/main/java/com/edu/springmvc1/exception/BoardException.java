package com.edu.springmvc1.exception;

public class BoardException extends RuntimeException{
	public BoardException(String msg) {
		super(msg);
	}
	public BoardException(String msg, Throwable e) {
		super(msg, e);
	}
}
