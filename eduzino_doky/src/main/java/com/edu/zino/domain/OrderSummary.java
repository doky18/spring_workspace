package com.edu.zino.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderSummary {
	private int order_summary_idx;
	private String order_summary_regdate;
	private int total_buy;//총구매금액
	private int total_pay;//지불금액
	private Member member;
	private Payment payment;
	private Paystate paystate;
	
	//이 주문 상세내역
	private List<OrderDetail> orderDetailList;
	
}
