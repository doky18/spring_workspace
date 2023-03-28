package com.edu.zino.domain;

import lombok.Data;

@Data
public class ProfilePhoto {
	private int profilePhoto_idx; //고유키
	private String profile_photo; //프로필사진

	private Member member;
}
