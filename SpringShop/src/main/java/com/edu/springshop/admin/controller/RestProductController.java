package com.edu.springshop.admin.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.UploadException;
import com.edu.springshop.model.product.ProductService;
import com.edu.springshop.util.Message;

//상품과 관련된 요청을 처리하는 하위 컨트롤러 

@RestController
@RequestMapping("/rest")
public class RestProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//서비스의 존재가 없다면, 컨트롤러계층과 모델 계층의 구분이 모호해진다
	//추후 모델을 완전히 재사용을 위해 분리시키려할 때 분리가 불가능하다
	@Autowired
	private ProductService productService;
	
	//상품 등록 요청 처리
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public ResponseEntity<Message> regist(Product product, HttpServletRequest request) {
		logger.info("product is "+product);
		
		//웹 환경과 관련된 코드이므로, 컨트롤러의 책임이다!
		//왜? 모델은 중립적이니까 관심도 없다
		ServletContext application = request.getSession().getServletContext();	
		String path=application.getRealPath("/resources/data/");
		logger.info("저장될 실제 경로는 "+path);
		
		//3단계
		productService.regist(product, path);

/*tipartFile[] photoList=product.getPhoto();
		logger.info("photo 배열은 "+photoList);
		
		for(MultipartFile photo : photoList) {
		//	photoList.transferTo(new File("path"));
		}*/
		
		Message message = new Message();
		message.setMsg("상품등록 성공");
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(UploadException.class)
	public ResponseEntity<String> handle(UploadException e){
		
		Message message = new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return null;
	}
	
}









