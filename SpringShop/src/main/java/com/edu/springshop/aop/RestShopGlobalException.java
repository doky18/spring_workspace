package com.edu.springshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edu.springshop.exception.EmailException;
import com.edu.springshop.exception.HashException;
import com.edu.springshop.exception.MemberException;
import com.edu.springshop.util.Message;

//하위 컨트롤러에서 해당 예외가 발생하면, 해당 하위 컨트롤러에서
//지정된 @ExceptionHandler가 먼저 적용되고,
//만일 해당 @ExceptionHandler가 지정되지 않으면,
//이 예외 객체가 처리할 것임
//@RestControllerAdive 자체가 RestController 에서 발생하는 예외만 처리한다는 보장을 하지 않는다

//Rest 한 것만 잡기 

@RestControllerAdvice(annotations = RestController.class)		//ControllerAdvice + @ResponseBody
public class RestShopGlobalException {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handle(MemberException e){
		logger.info("글로벌 예외~감지~");
		
		Message message = new Message();
		message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	
	 //글로벌 익셉션으로 이사
		@ExceptionHandler(EmailException.class)
		public ResponseEntity<Message> handle(EmailException e){
			logger.info("글로벌 예외~감지~"+e);
			
			Message message = new Message();
			message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
			
			ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			return entity;
		};

		
		 //글로벌 익셉션으로 이사
		@ExceptionHandler(HashException.class)
		public ResponseEntity<Message> handle(HashException e){
			logger.info("쇼핑몰 글로벌 예외 감지"+e);
			
			Message message = new Message();
			message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
			
			ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
			return entity;
		};
}
