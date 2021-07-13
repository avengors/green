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
    <div><label for="userId">아이디</label><input type="text" name="userId" id="userId"></div>
    <div><label for="userPw">비밀번호</label><input type="password" name="userPw" id="userPw"></div>
    <div><label for="name">이름</label><input type="text" name="name" id="name"></div>
    <div><label for="birth">생년월일</label><input type="text" name="birth" id="birth"></div>
    <div><label for="male">남</label><input type="radio" name="gender" id="male" value="남"></div>
    <div><label for="female">여</label><input type="radio" name="gender" id="female" value="여"></div>
    <div><label for="address">주소</label><input type="text" name="address" id="address"></div>
    <button type="submit">가입</button>
</form>

</body>
</html>