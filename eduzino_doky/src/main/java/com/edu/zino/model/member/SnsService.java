package com.edu.zino.model.member;

import com.edu.zino.domain.Sns;

public interface SnsService {
	public Sns selectByIdx(int sns_idx);
	public Sns selectByType(String sns_type);
}

