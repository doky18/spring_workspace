insert into TOP_CATEGORY(top_category_idx,top_name) values(seq_top_category.nextval,'IT');
insert into TOP_CATEGORY(top_category_idx,top_name) values(seq_top_category.nextval,'디자인');
insert into TOP_CATEGORY(top_category_idx,top_name) values(seq_top_category.nextval,'마케팅');
insert into TOP_CATEGORY(top_category_idx,top_name) values(seq_top_category.nextval,'외국어');
insert into TOP_CATEGORY(top_category_idx,top_name) values(seq_top_category.nextval,'기타');

select * from top_category;

insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'프론트엔드',1);
insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'백엔드',1);

insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'CADㆍ3D모델링',2);
insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'사진ㆍ영상',2);

insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'기획ㆍ전략',3);
insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'경영',3);

insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'영어',4);
insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'중국어',4);

insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'자기개발',5);
insert into MID_CATEGORY(mid_category_idx,mid_name,top_category_idx) values(seq_mid_category.nextval,'예술',5);

<<<<<<< HEAD
<<<<<<< HEAD
select * from mid_category

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'HTML/CSS',1);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'JavaScript',1);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'JAVA',2);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'C',2);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'AutoCAD',3);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'SketchUp',3);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'모션그래픽',4);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'영상제작',4);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'서비스 기획',5);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'PT',5);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'회계',6);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'재테크',6);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'토익',7);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'OPIc',7);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'HSK',8);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'회화',8);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'교양',9);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'출간출판',9);

insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'뜨개질',10);
insert into SUB_CATEGORY(sub_category_idx,sub_name,mid_category_idx) values(seq_sub_category.nextval,'캘리그라피',10);




select * from sub_category
=======
>>>>>>> 4b5f5943f54a43d599168cedf087a264d33380de
=======
>>>>>>> 090364d14f2248e255f6a980387b9adb6e56c4f0
