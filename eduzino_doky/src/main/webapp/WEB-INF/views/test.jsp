<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="javax.sql.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
    // 커넥션 객체가 생성되는지 확인 (JNDI 이용)
    InitialContext context = new InitialContext();
    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/aws");

    Connection con = ds.getConnection();
    out.print("윈도우의 접속객체는" + con);

    String sql ="select from gallery";
    PreparedStatement pstmt = con.prepareStatement(sql);

    ResultSet rs =pstmt.executeQuery();
    rs.next();
    out.print(rs.getString("title"));

    con.close();

%>