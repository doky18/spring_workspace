package com.edu.springshop.aop;
/*
 * 쇼핑몰 어플리케이션에 전반적으로 적용될 수 있는 공통코드를 AOP의 advice로 정의해놓고,
 * 필요한 곳에 적용시켜본다..
 * */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

//눈여겨 보고 있다가 메서드를 대신할 대리객체
public class CategoryAdvice {
	private Logger logger=LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private CategoryService categoryService;
	
	//아래의 메서드에서 서비스의 selectAll()을 호출하여 ModelAndView에 저장
	//예시에 ding
	public Object getCategoryList(ProceedingJoinPoint joinPoint) throws Throwable {
		//joinPoint의 목적은 원래 호출하려던 메서드를 호출 전, 후에 관여할 수 있는 기능을 지원
		//원래 호출하려던 메서드들 호출 전, 후에 관여할 수 있는 기능을 지원
		Object returnObj = null;

		String target=joinPoint.getTarget().getClass().getName();
        logger.info("원래 호출하려던 객체는 is "+target);
		
		Signature sig =joinPoint.getSignature();
		String method = sig.getName();
		logger.info("원래 호출하려던 메서드는 "+ method);
		
		//호출하려던 메서드의 매개변수에서 request 객체 가져오기
		Object[] args =joinPoint.getArgs();
		HttpServletRequest request =  null;
		
		for(Object arg: args) {
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		//uri 끄집어내기
		String uri = request.getRequestURI();
		
		if(
			uri.equals("/rest/member")	||	//비동기방식의 가입요청은 메뉴제외
			uri.equals("/member/regist")		//동기방식의 가입 요청은 메뉴 제외
			
		) {//aop 처리를 안하려고. 제외될 요청 uri. 카테고리 처리가 필요없는 요청들...
			returnObj = joinPoint.proceed();
			
		}else {
			//원래는 컨트롤러들에서 매번 수행해야 했던 Category 가져오기 공통 코드를
			//여기서 수행하면 컨트롤러에 들어갈 코드가 줄어든다~!
			List categoryList =categoryService.selectAll();
			
			//원래 호출하려던 메서드를 진행시킨다
			ModelAndView mav=null;
			
			returnObj = joinPoint.proceed();		//원래 호출하려면 메서드 호출을 여기서 진행
			
			if(returnObj instanceof ModelAndView) {	//returnObj의 자료형이 ModelAndView
				mav = (ModelAndView)returnObj;		//형변환을 해서 
				mav.addObject("categoryList", categoryList);
				returnObj =mav;		//반환값에 mav 대입
			}
		}
		return returnObj;
	}

}
