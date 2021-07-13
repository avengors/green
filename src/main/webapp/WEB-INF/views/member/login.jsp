<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form method="POST">
    <label for="userId">아이디</label><input type="text" name="userId" id="userId">
    <label for="userPw">비밀번호</label><input type="password" name="userPw" id="userPw">
    <button type="submit">로그인</button>
</form>

</body>
</html>