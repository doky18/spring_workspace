-- fk 제약조건
ALTER TABLE member ADD CONSTRAINT FK_sns_name_TO_member_1 FOREIGN KEY (
<<<<<<< HEAD
	social_login_idx
=======
	sns_name_idx
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
)
REFERENCES sns_name (
	sns_name_idx
);

ALTER TABLE blacklist ADD CONSTRAINT FK_member_TO_blacklist_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE admin ADD CONSTRAINT FK_grade_TO_admin_1 FOREIGN KEY (
	grade_idx
)
REFERENCES grade (
	grade_idx
);

ALTER TABLE mid_category ADD CONSTRAINT FK_top_category_TO_mid_category_1 FOREIGN KEY (
	top_category_idx
)
REFERENCES top_category (
	top_category_idx
);

ALTER TABLE section ADD CONSTRAINT FK_subject_TO_section_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE movie ADD CONSTRAINT FK_section_TO_movie_1 FOREIGN KEY (
	section_idx
)
REFERENCES section (
	section_idx
);

ALTER TABLE sub_category ADD CONSTRAINT FK_mid_category_TO_sub_category_1 FOREIGN KEY (
	mid_category_idx
)
REFERENCES mid_category (
	mid_category_idx
);

ALTER TABLE goal ADD CONSTRAINT FK_subject_TO_goal_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE requirement ADD CONSTRAINT FK_subject_TO_requirement_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE subject ADD CONSTRAINT FK_teacher_TO_subject_1 FOREIGN KEY (
	teacher_idx
)
REFERENCES teacher (
	teacher_idx
);

ALTER TABLE subject ADD CONSTRAINT FK_sub_category_TO_subject_1 FOREIGN KEY (
	sub_category_idx
)
REFERENCES sub_category (
	sub_category_idx
);

ALTER TABLE cart ADD CONSTRAINT FK_member_TO_cart_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE cart ADD CONSTRAINT FK_subject_TO_cart_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE wish ADD CONSTRAINT FK_member_TO_wish_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE wish ADD CONSTRAINT FK_subject_TO_wish_1 FOREIGN KEY (
	subejct_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE order_summary ADD CONSTRAINT FK_member_TO_order_summary_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE order_summary ADD CONSTRAINT FK_payment_TO_order_summary_1 FOREIGN KEY (
	payment_idx
)
REFERENCES payment (
	payment_idx
);

ALTER TABLE order_summary ADD CONSTRAINT FK_paystate_TO_order_summary_1 FOREIGN KEY (
	paystate_idx
)
REFERENCES paystate (
	paystate_idx
);

ALTER TABLE chat ADD CONSTRAINT FK_member_TO_chat_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE review ADD CONSTRAINT FK_member_TO_review_1 FOREIGN KEY (
	member_idx
)
REFERENCES member (
	member_idx
);

ALTER TABLE review ADD CONSTRAINT FK_subject_TO_review_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE adminboard ADD CONSTRAINT FK_target_TO_adminboard_1 FOREIGN KEY (
	target_idx
)
REFERENCES target (
	target_idx
);

ALTER TABLE adminboard ADD CONSTRAINT FK_admin_TO_adminboard_1 FOREIGN KEY (
	admin_idx
)
REFERENCES admin (
	admin_idx
);

ALTER TABLE teacherboard ADD CONSTRAINT FK_teacher_TO_teacherboard_1 FOREIGN KEY (
	teacher_idx
)
REFERENCES teacher (
	teacher_idx
);

ALTER TABLE message ADD CONSTRAINT FK_chat_TO_message_1 FOREIGN KEY (
	chat_idx
)
REFERENCES chat (
	chat_idx
);

ALTER TABLE order_detail ADD CONSTRAINT FK_order_summary_TO_order_detail_1 FOREIGN KEY (
	order_summary_idx
)
REFERENCES order_summary (
	order_summary_idx
);

ALTER TABLE order_detail ADD CONSTRAINT FK_subject_TO_order_detail_1 FOREIGN KEY (
	subject_idx
)
REFERENCES subject (
	subject_idx
);

ALTER TABLE discount_log ADD CONSTRAINT FK_order_summary_TO_discount_log_1 FOREIGN KEY (
	order_summary_idx
)
REFERENCES order_summary (
	order_summary_idx
);
