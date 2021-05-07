<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>SSAFY BOOK CAFE</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="img/favicon.ico" />
    <!-- bootstrap을 위한 js & css 등록 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="reference/js/httpRequest.js"></script>
    <script type="text/javascript" src="reference/js/cafe.js"></script>
  </head>
  <body>

    <!-- 상단 Header Start  -->
    <nav class="navbar navbar-expand-sm bg-light fixed-top shadow">
      <div class="container">
        <a class="navbar-brand" href="${root}/">Happy House</a>
        <button
          class="navbar-toggler navbar-toggler-right bg-secondary text-white"
          type="button"
          data-toggle="collapse"
          data-target="#navb"
        >
          <span class="navbar-toggler-icon">-</span>
        </button>
        <div id="navb" class="collapse navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link text-secondary" href="${root}/main?act=list&key=&word=">공지사항</a>
            </li>
          </ul>
         <div >

         <!-- 상단 오른쪽  -->
		<nav class="navbar navbar-expand-sm justify-content-end" >
		  <ul class="navbar-nav text-black" >
		  <c:if test="${userinfo eq null}">
		    <li class="nav-item mr-2">
		      <a href="${root}/user/join"> Sign up </a>
		    </li>
		    <li class="nav-item mr-2">
		      <a href="${root}/user/login"> Login </a>
		    </li>
		    </c:if>
		    <c:if test="${userinfo ne null}">
		    <li class="nav-item mr-2">
		    <a href="${root}/user/logout"> Logout </a>
		    </li>
		    <li class="nav-item mr-2">
		      <a href="${root}/user/mypage"> MyPage </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
		</div>
        </div>
      </div>
    </nav>
    <!-- 상단 오른쪽 -->
    <!-- 상단 Header End  -->
    
    <!-- 상단 jumbotron start -->
    <div style="height: 60px;"></div>
	<div class="jumbotron jumbotron-fluid" style="margin-bottom:0px; background-image: url('./reference/img/house.jpeg');">
	  <div class="container" style="text-align: center;">
	    <h1>Sitemap</h1>      
	    <p>사이트맵</p>
	  </div>
	</div>
	 <!-- 상단 jumbotron end -->
	 
    <div class="container">
        <!-- 중앙 contents start -->
        <div class="row">
        	<h2>Site Map</h2>
           	<div class="col">
           		<div class="custom-sitemap-list-div">
           	  		<h5>회원 정보 관련</h5>
           	  		<c:if test="${userinfo eq null}">
				   		<ul class="list-group">
				     		<li class="list-group-item"><a href="${root}/user/join">회원 가입</a></li>
				     		<li class="list-group-item"><a href="${root}/user/login">로그인</a></li>
				     		<li class="list-group-item"><a href="${root}/user/findpassword">비밀번호 찾기</a></li>
				   		</ul>
			   		</c:if>
			   		<c:if test="${userinfo ne null}">
			   			<ul class="list-group">
				     		<li class="list-group-item"><a href="${root}/user/logout">로그아웃</a></li>
				     		<li class="list-group-item"><a href="${root}/user/mypage">마이 페이지</a></li>
				   		</ul>
			   		</c:if>
           		</div>
           		<c:if test="${userinfo ne null}">
           			<div class="custom-sitemap-list-div">
				   		<h5>아파트 매매 정보 및 공지사항</h5>
				  		<ul class="list-group">
				     		<li class="list-group-item"><a href="${root}/search/dong">아파트 정보 보기</a></li>
				     		<li class="list-group-item"><a href="${root}/">공지사항</a></li>
				   		</ul>
					</div>
			   	</c:if>
				
           </div>
		</div>
    </div>
        <!-- 중앙 contents end -->

    <!-- 하단 Footer Start  -->
    <footer class="navbar navbar-expand-md">
      <div class="row">
        <div class="col-md-12">
          <ul style="list-style: none;">
            <li><a class="nav-link text-secondary" href="#" style="font-size: x-large;">Find us</a></li>
            <li><a class="nav-link text-secondary" href="#">(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</a></li>
            <li><a class="nav-link text-secondary" href="#">1544-9001</a></li>
            <li><a class="nav-link text-secondary" href="#">admin@ssafy.com</a></li>
            <li><label class="nav-link text-secondary">&copy; SSAFY Corp.</label></li>
          </ul>
        </div>
      </div>
    </footer>
    <!-- 하단 Footer End  -->
  </body>
</html>
