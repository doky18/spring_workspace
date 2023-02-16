package com.edu.springboard.client.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.gallery.GalleryService;

//갤러리와 관련된 모든 요청을 처리하는 하위 컨트롤러
@Controller
public class GalleryController {
	private Logger logger =LoggerFactory.getLogger(this.getClass().getName());
	
	//느슨하게 보유
	@Autowired
	private GalleryService galleryService;
	
	@GetMapping("/gallery/registform")
	public ModelAndView registForm() {
		return new ModelAndView("gallery/regist");
	}
	
	/*
	//갤러리 업로드 요청 처리 (가볍게 추상화 시켰음)
    @PostMapping("/gallery/regist")
    @ResponseBody		//메서드의 반환값을 jsp로 매핑하지 말고 순수 데이터로 처리하여 응답정보로 보낸다
    public ModelAndView regist(Gallery gallery, HttpServletRequest request) {
        MultipartFile[] photo=gallery.getPhoto();
        
        for(int i=0;i<photo.length;i++) {
			logger.info("업로드된 파일은 "+photo[i].getOriginalFilename());
		}
        //3단계 : 글 등록하기 (db+file)
        HttpSession httpSession = request.getSession();		//자료형 = 
        ServletContext application = httpSession.getServletContext();
        String realPath=application.getRealPath("/resources/data/");
		logger.info(realPath); 		//파일의 경로 확인을 위함
        galleryService.regist(gallery, realPath);		//regist에서 무슨 일이 벌어지는지는 모름 = 추상화 
        
		return "hi";		//WEB-INF
	}*/
	
	//컨트롤러 메서드들에서 예외가 발생했을때의 처리
    @ExceptionHandler(GalleryException.class)
    public ModelAndView handel(GalleryException e) {
    	ModelAndView mav = new ModelAndView("error/result");
    	mav.addObject("e", e);
    	return null;
    }
    
    @ExceptionHandler(PhotoException.class)
    public ModelAndView handel(PhotoException e) {
    	ModelAndView mav = new ModelAndView("error/result");
    	mav.addObject("e", e);
    	return null;
    }
    
    @ExceptionHandler(FileUploadException.class)
    public ModelAndView handel(FileUploadException e) {
    	ModelAndView mav = new ModelAndView("error/result");
    	mav.addObject("e", e);
    	return null;
    }
    
    
    
    
    
    
    
    
    
    
}
