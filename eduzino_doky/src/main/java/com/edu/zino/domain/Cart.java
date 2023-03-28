package com.edu.zino.domain;

import lombok.Data;

@Data
public class Cart {
	private int cart_idx;
	private Member member;
	private Subject subject;
}
