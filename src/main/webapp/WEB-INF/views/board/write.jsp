<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>

<main>
    <form method="post" enctype="multipart/form-data">
        <div>
            <input type="radio" name="category" id="ocean" value="ocean">
            <label for="ocean">Ocean</label>
            <input type="radio" name="category" id="air" value="air">
            <label for="air">Air</label>
            <input type="radio" name="category" id="land" value="land" checked>
            <label for="land">Land</label>
        </div>
        <div>
            <label for="title">제목</label>
            <input type="text" name="title" id="title">
        </div>
        <div>
            <label for="content">본문</label>
            <textarea name="content" id="content" cols="30" rows="10"></textarea>
        </div>
        <div>
            <input type="file" name="uploadFile">
        </div>
        <div>
            <a href="${cpath}/board">취소</a>
            <button type="submit">작성</button>
        </div>
    </form>
</main>

<%@ include file="../footer.jsp" %>