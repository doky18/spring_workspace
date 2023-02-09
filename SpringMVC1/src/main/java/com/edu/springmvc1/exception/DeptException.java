package com.edu.springmvc1.exception;

public class DeptException extends RuntimeException{
	public DeptException(String msg) {
		super(msg);
	}
	public DeptException(String msg, Throwable e) {
		super(msg, e);
	}
}
