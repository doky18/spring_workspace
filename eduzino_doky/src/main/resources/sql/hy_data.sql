--임시데이터

select table_name from user_tables;

---------------------------------------
 
insert into member(member_idx,member_nickname, member_id, sns_name_idx)
 values(1,'marlang','kite@naver',1);
 
insert into teacher(teacher_idx, member_idx)
 values(1,1);

insert into subject(subject_idx,subject_title,subject_subTitle,subject_price,subject_detail,teacher_idx,sub_category_idx)
 values(1, 'spring boot','jhonjam',35000,'ddfdfdf',1,1);
 
insert into subject(subject_idx,subject_title,subject_subTitle,subject_price,subject_detail,teacher_idx,sub_category_idx)
 values(2, 'java','javajava',40000,'aaaa',1,1);
 
insert into cart(cart_idx,member_idx,subject_idx)
 values(1,1,1);
 
insert into order_summary(order_summary_idx, member_idx, payment_idx, paystate_idx, total_buy, total_pay)
 values(1, 1, 1, 1, 1, 35000);
 
insert into order_detail(order_detail_idx, order_summary_idx, subject_idx)
 values(1, 1, 1);
 
 

insert into member(member_idx,member_nickname, member_id, sns_name_idx)
 values(2,'mimi','mimi@naver', 1);
 
insert into  order_summary(order_summary_idx, member_idx, payment_idx, paystate_idx, total_buy, total_pay)
 values(2,2,2,2,1,35000);
  
insert into order_detail(order_detail_idx, order_summary_idx, subject_idx)
 values(2, 2, 1);
 
 
 
insert into member(member_idx,member_nickname, member_id, sns_name_idx)
 values(3,'roma','roma@naver', 1);
 
insert into  order_summary(order_summary_idx, member_idx, payment_idx, paystate_idx, total_buy, total_pay)
 values(3,3,3,3,1,35000);
  
insert into order_detail(order_detail_idx, order_summary_idx, subject_idx)
 values(3, 3, 1);
 
 

insert into member(member_idx,member_nickname, member_id, sns_name_idx)
 values(4,'zizi','zizi@naver', 1);
 
insert into  order_summary(order_summary_idx, member_idx, payment_idx, paystate_idx, total_buy, total_pay)
 values(4,4,4,4,2,75000);
  
insert into order_detail(order_detail_idx, order_summary_idx, subject_idx)
 values(4, 4, 1);
 
insert into order_detail(order_detail_idx, order_summary_idx, subject_idx)
 values(5, 4, 2);
 
 haeyoung
 
 