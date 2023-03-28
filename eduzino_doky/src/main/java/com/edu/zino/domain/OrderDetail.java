package com.edu.zino.domain;

import lombok.Data;

@Data
//주문상세내역
public class OrderDetail {
	private int order_detail_idx;
	private OrderSummary orderSummary;
	private Subject subject;
}
