<%@ page import="java.sql.*" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
    String method = request.getParameter("method");
    String amount = request.getParameter("amount");
    String paymentId = UUID.randomUUID().toString();

    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:paymentdb", "sa", "");
        String sql = "INSERT INTO payments (payment_id, method, amount) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, paymentId);
        pstmt.setString(2, method);
        pstmt.setBigDecimal(3, new java.math.BigDecimal(amount));
        pstmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }

    response.sendRedirect("index.jsp");
%>