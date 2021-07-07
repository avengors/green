<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial scale=1">
<link href="${cpath}/resources/css/style.css" rel="stylesheet" />
<title>Green</title>

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>
	
	<!-- loginForm -->
    <div class="loginForm hidden">

        <form method="POST">
            <h2>로그인</h2>
            <div class="login_id">
                <input type="email" name="emain" placeholder="아이디">
                <input type="password" name="userpw" placeholder="비밀번호">
            </div>
            <div class="submitBtn">
                <input type="submit" value="로그인">
            </div>
            <div class="anotherLogin">
                <div id="naverIdLogin"></div>
                <div class="instaBtn">instagram</div>
            </div>
        </form>
    </div>

	<!-- header -->
    <header>
        <div class="cate"><a href="">≡</a></div>
        <div class="title">
        	<a href="${cpath }">
        		<h1>Green</h1>
        	</a>
        </div>
        <div class="memberInform">
			<p>
            	<a href="" class="login">로그인</a>
            	<a href="${cpath }/member/join" class="join">회원가입</a>
			</p>
        </div>
    </header>

    
    <!-- aside -->
    <aside class="mainAside">
        <div class="closeBtn"><a href=""><</a></div>
        <div class="asideList">
            <p><a href="${cpath }">홈</a></p>
            <p><a href="${cpath }/board/introduce">소개글</a></p>
            <p><a href="${cpath }/board/news">새소식</a></p>
            <p><a href="${cpath }/board/write">글쓰기</a></p>
            <p><a href="${cpath }/board/oneWord">한마디</a></p>
        </div>
    </aside>
    
    
    <!-- overlay -->
    <div class="aisdeOverlay hidden"></div>
    <div class="overlay hidden"></div>
    
    
    
    <script>
        //aside
        const aisdeOverlay = document.querySelector('.aisdeOverlay')
        const overlay = document.querySelector('.overlay')
        const openBtn = document.querySelector('.cate > a')
        const closeBtn = document.querySelector('.closeBtn > a')
        const aside = document.querySelector('.mainAside')
        const body = document.querySelector('body')

        const openHandler = (event) => {
            event.preventDefault()
            aside.style.left = '0px'
            aisdeOverlay.classList.remove('hidden')
            body.classList.add('overFlow')
        }
        const closeHandler = (event => {
            event.preventDefault()
            aside.style.left = '-350px'
            aisdeOverlay.classList.add('hidden')
            body.classList.remove('overFlow')
        })
        openBtn.onclick = openHandler
        closeBtn.onclick = closeHandler
        aisdeOverlay.onclick = closeHandler

        // joinBtn
        const loginForm = document.querySelector('.loginForm')
        const loginBtn = document.querySelector('.login')

        const loginHandler = (event) => {
            event.preventDefault()
            loginForm.classList.remove('hidden')
            overlay.classList.remove('hidden')
            body.classList.add('overFlow')
        }
        loginBtn.onclick = loginHandler
        overlay.onclick = () => {
            overlay.classList.add('hidden')
            loginForm.classList.add('hidden')
            body.classList.remove('overFlow')
        }
       
        //naver
        var naverLogin = new naver.LoginWithNaverId(
            {
                clientId: "k8CiCXDHVTwweZZ7kjMQ",
                callbackUrl: "http://test/naver_login.asp",
                isPopup: false, /* 팝업을 통한 연동처리 여부 */
                loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
            }
        );

        /* 설정정보를 초기화하고 연동을 준비 */
        naverLogin.init();
    </script>
    
    
    
    
    
    
    
    