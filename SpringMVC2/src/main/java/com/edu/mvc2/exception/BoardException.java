package com.edu.mvc2.exception;

public class BoardException extends RuntimeException{
	public BoardException(String msg) {
		super(msg);
	}
	public BoardException(String msg, Throwable e) {
		super(msg, e);
	}
}