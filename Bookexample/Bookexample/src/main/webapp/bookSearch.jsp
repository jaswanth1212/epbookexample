<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Search Results</title>
</head>
<body>
    <h1>Book Search Results</h1>
    <p>Debug: Number of books: ${bookList.size()}</p>
    <p>Debug: Is bookList empty? ${empty bookList}</p>
    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Book Price</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.bid}</td>
                <td>${book.bname}</td>
                <td>${book.bprice}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="index.jsp">Back to Search</a>
</body>
</html>