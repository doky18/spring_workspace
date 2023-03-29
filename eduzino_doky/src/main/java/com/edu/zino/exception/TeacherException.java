package com.edu.zino.exception;

public class TeacherException extends RuntimeException{
	
	public TeacherException(String msg) {
		super(msg);
	}
	
	public TeacherException(String msg,Throwable e) {
		super(msg,e);
	}
}
