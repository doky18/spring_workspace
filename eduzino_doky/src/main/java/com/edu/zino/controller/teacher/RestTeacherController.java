package com.edu.zino.controller.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.zino.model.root.OrderSummaryService;

@RestController
@RequestMapping("/rest")
public class RestTeacherController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderSummaryService orderSummaryService;
	
}
