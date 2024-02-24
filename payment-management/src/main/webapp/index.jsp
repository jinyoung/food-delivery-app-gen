<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Management</title>
</head>
<body>

<sql:setDataSource var="dataSource" driver="org.h2.Driver"
                   url="jdbc:h2:mem:paymentdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'"
                   user="sa" password=""/>

<sql:update dataSource="${dataSource}" var="initDb">
    CREATE TABLE IF NOT EXISTS payments (
        payment_id VARCHAR(255) PRIMARY KEY,
        method VARCHAR(255),
        amount DECIMAL
    );
</sql:update>

<h2>Create Payment</h2>
<form action="createPayment.jsp" method="post">
    Payment Method: <input type="text" name="method" required><br>
    Amount: <input type="text" name="amount" required><br>
    <input type="submit" value="Submit">
</form>

<h2>Payments</h2>
<sql:query dataSource="${dataSource}" var="result">
    SELECT * FROM payments;
</sql:query>
<table border="1">
    <tr>
        <th>Payment ID</th>
        <th>Method</th>
        <th>Amount</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.payment_id}"/></td>
            <td><c:out value="${row.method}"/></td>
            <td><c:out value="${row.amount}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>