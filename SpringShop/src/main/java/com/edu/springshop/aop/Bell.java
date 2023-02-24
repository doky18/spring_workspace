package com.edu.springshop.aop;
/*
 * 어플리케이션의 핵심 관심사항(core concern)은 아니지만 모든 영역에 전반적으로 사용되는 기능을
 * 공통관심사항 (cross cutting concern)이라하며, Bell을 공통 관심사항으로 정의해보자
 * 
 * 공통관심 사항 코드를 Advice라 한다. 시점을 Advice라고도 한다
 */


//이 클래스는 어플리케이션에서 공통로직으로 정의
//@ 안붙였으니까 직접 shop-context.xml에 bean으로 등록 한 것
public class Bell {
	
	public void ding() {
		System.out.println("딩동댕♬");
	}

}
