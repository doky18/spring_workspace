package com.edu.springboard.client.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.gallery.GalleryService;
import com.google.gson.Gson;

//RestController일 경우, 모든 메서드에 @ResponseBody를 생략가능 
@RestController
public class RestGalleryController {
	private Logger logger =LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private GalleryService galleryService;
	
	//갤러리 업로드 요청 처리 (가볍게 추상화 시켰음)
    @PostMapping("/gallery/regist")
    @ResponseBody		//메서드의 반환값을 jsp로 매핑하지 말고 순수 데이터로 처리하여 응답정보로 보낸다
    public String regist(Gallery gallery, HttpServletRequest request) {
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
        
		return "ok";		
	}
    
    //비동기 목록 요청처리 (주요 클라이언트 -web - ajax)
    //앱 (안드로이드, 아이폰)
    @GetMapping("/rest/gallery/list")
    public List<Gallery> getList() {
    	//3단계 :
    	List <Gallery> galleryList = galleryService.selectAll();
    	//Gson gson = new Gson();
    	//String jsonList=gson.toJson(galleryList);
    	
    	return galleryList;
    }
    
    //갤러리 한 건 가져오기
    @GetMapping("/rest/gallery/detail")
    public Gallery getDetail(int gallery_idx) {
    	//3단계 일 시키기
    	Gallery gallery = galleryService.select(gallery_idx);
    	return gallery;
    }
    
  //컨트롤러 메서드들에서 예외가 발생했을때의 처리
    @ExceptionHandler(GalleryException.class)
    @ResponseBody
    public String handel(GalleryException e) {
    	return "error";
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
