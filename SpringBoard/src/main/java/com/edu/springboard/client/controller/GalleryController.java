package com.edu.springboard.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//갤러리와 관련된 모든 요청을 처리하는 하위 컨트롤러
@Controller
public class GalleryController {
	
	@GetMapping("/gallery/registform")
	public ModelAndView registForm() {
		
		
		return new ModelAndView("gallery/regist");
	}
}
