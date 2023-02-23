<%@page import="com.google.gson.Gson"%>
<%@page import="com.jspshop.util.MessageObject"%>
<%@page import="com.jspshop.exception.MemberException"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.jspshop.mybatis.MybatisConfig"%>
<%@page import="com.jspshop.repository.MemberDAO"%>
<%@ page contentType="application/json;charset=UTF-8"%>
<%!
	MybatisConfig mybatisConfig = MybatisConfig.getInstance();
	MemberDAO memberDAO = new MemberDAO();	
%>
<%
	//dao에게 주입(injection)
	SqlSession sqlSession =  mybatisConfig.getSqlSession();
	memberDAO.setSqlSession(sqlSession);
	
	//파라미터 받기 전에 설정해야 한다. 왜?그래야 받을때 한글이 깨지지 않음.
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.jspshop.domain.Member"/>
<jsp:setProperty property="*" name="member"/>
<%	
	System.out.println(member.getId());		//dto에 담아져있는 데이터들이 찍히는것 
	System.out.println(member.getPass());
	System.out.println(member.getName());
	System.out.println(member.getEmail());
	
	MessageObject mo=new MessageObject();
	
	try{
		memberDAO.insert(member);
		mo.setCode(1);
		mo.setMsg("등록성공");
		sqlSession.commit();
	}catch(MemberException e){
		mo.setCode(0);
		mo.setMsg(e.getMessage());//에러메시지 자동 채우기
	}
	
	//out.print(mo);		-- 이렇게 보내면 문자열이 아니라 주소값이 찍힘. 
	//문자열로 해주기 위해서,,,,
	Gson gson = new Gson();
	out.print(gson.toJson(mo)); // JSON 문자열로 변환하여 결과 전송
	
	mybatisConfig.release(sqlSession);
%>








