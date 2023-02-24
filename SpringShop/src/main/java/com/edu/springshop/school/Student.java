package com.edu.springshop.school;

import com.edu.springshop.aop.Bell;

//학생을 정의한다
public class Student {
	Bell bell;
	public void study() {
		System.out.println("공부해요");
	}
	public void haveLunch() {
		System.out.println("밥먹어요");
	}
	public void sleep() {
		System.out.println("잠자요");
	}
}
