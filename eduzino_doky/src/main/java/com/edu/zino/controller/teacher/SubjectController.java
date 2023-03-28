package com.edu.zino.controller.teacher;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.zino.vo.StudyPlanVO;

@Controller
public class SubjectController {
	
	private final static int GOAL = 0;
	private final static int DETAIL = 1;
	private final static int MOVIE = 2;
	private final static int PRIVIEW = 3;
	
	
	@GetMapping("/regist/goal")
	public ModelAndView getRegistFormGoal(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/teacher/subject/registform-goal");
		StudyPlanVO studyPlanVO = new StudyPlanVO(GOAL, "학습목표");
		mav.addObject("studyPlanVO", studyPlanVO);
		return mav;
	}
	
	@GetMapping("/regist/detail")
	public ModelAndView getRegistFormDetail(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/teacher/subject/registform-detail");
		StudyPlanVO studyPlanVO = new StudyPlanVO(DETAIL, "강의내용");
		mav.addObject("studyPlanVO", studyPlanVO);
		return mav;
	}
	
	@GetMapping("/regist/movie")
	public ModelAndView getRegistFormMovie(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/teacher/subject/registform-movie");
		StudyPlanVO studyPlanVO = new StudyPlanVO(MOVIE, "커리큘럼");
		mav.addObject("studyPlanVO", studyPlanVO);
		return mav;
	}
	
	

}
