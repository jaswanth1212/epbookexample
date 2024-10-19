<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Search</title>
</head>
<body>
    <h1>Book Search</h1>
    <form action="BookServlet" method="get">
        <label for="keyword">Enter keyword:</label>
        <input type="text" id="keyword" name="keyword" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>