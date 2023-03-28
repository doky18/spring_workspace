package com.edu.zino.domain;

import lombok.Data;

@Data
//찜내역
public class Wish {
	private int wish_idx;
	private Member member;//누가
	private Subject subject;//무엇을
}
