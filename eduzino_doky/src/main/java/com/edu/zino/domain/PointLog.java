package com.edu.zino.domain;

import lombok.Data;

@Data
//포인트적립내역
public class PointLog {
	private int point_log_idx;
	private int amount;//적립내역
	private String point_log_memo;//사유
	private OrderSummary order_summary;//주문내역
}
