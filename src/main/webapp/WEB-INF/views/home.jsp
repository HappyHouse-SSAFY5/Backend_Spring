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
    <script type="text/javascript">
	$(document).ready(function() {
		
		var cafeArea = {
				"서울" : ["역삼점", "선릉점"],
				"대전" : ["학하점", "봉명점"],
				"구미" : ["연수원점", "구미사업장"],
				"광주" : ["하남산단점", "광주역점"]
		};
		
		var officePosition = {
				"역삼점" : 	{ "lat" : 37.500613, "lng" : 127.036431},	
				"선릉점" : 	{ "lat" : 37.504268, "lng" : 127.048188},	
				"학하점" : 	{ "lat" : 36.355360, "lng" : 127.298294},	
				"봉명점" : 	{ "lat" : 36.358843, "lng" : 127.344192},	
				"연수원점" : 	{ "lat" : 36.098594, "lng" : 128.389770},	
				"구미사업장" : 	{ "lat" : 36.109553, "lng" : 128.415011},	
				"하남산단점" : 	{ "lat" : 35.204279, "lng" : 126.807198},	
				"광주역점" : 	{ "lat" : 35.165476, "lng" : 126.909216}
		};
		
		var officeAddress = {
				"역삼점" : 	"서울특별시+강남구+역삼동+테헤란로+212",	
				"선릉점" : 	"서울특별시 강남구 역삼동 테헤란로 334 LG 화재빌딩",	
				"학하점" : 	"대전광역시 유성구 덕명동 124",	
				"봉명점" : 	"대전광역시 유성구 봉명동 대학로 60 봉명가든 6층",	
				"연수원점" : 	"경상북도 구미시 공단동 259",	
				"구미사업장" : 	"경상북도 구미시 임수동 94",	
				"하남산단점" : 	"107 하남산단6번로 광산구 광주광역시",	
				"광주역점" : 	"광주광역시 북구 중흥동 611"
		};
		
		$(".dropdown-item.cafe_area").click(function() {
			var selArea = $(this).text();
			$("#areaBtn").text(selArea);
			var offices = cafeArea[selArea];
			$("#office_div").empty();
			$.each(offices, function(i, office) {
				$("#office_div").append('<label class="dropdown-item cafe_office">' + office + '</label>');
			});
		});
		
		
		
		//officePosition의 lat, lng를 이용한 marker
		$(document).on("click", ".dropdown-item.cafe_office", function() {
			var selOffice = $(this).text();
			$("#officeBtn").text(selOffice);
			var office = officePosition[selOffice];
			deleteMarkers();
			var officemarker = {
					coords: {lat: office.lat, lng: office.lng},
					iconImage: null,
					content: selOffice
			};
			addMarker(officemarker);
		});
	});
	</script>
  </head>
  <body>

    <!-- 상단 Header Start  -->
    <nav class="navbar navbar-expand-sm bg-light fixed-top shadow">
      <div class="container">
        <a class="navbar-brand" href="./main.jsp">Happy House</a>
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
		      <a href="${root}/main?act=mvsignup"> Sign up </a>
		    </li>
		    <li class="nav-item mr-2">
		      <a href="${root}/main?act=mvlogin"> Login </a>
		    </li>
		    </c:if>
		    <c:if test="${userinfo ne null}">
		    <li class="nav-item mr-2">
		    <a href="${root}/main?act=logout"> Logout </a>
		    </li>
		    <li class="nav-item mr-2">
		      <a href="${root}/main?act=mypage"> MyPage </a>
		    </li>
		    </c:if>
		  </ul>
		</nav>
		</div>
       
          <ul id="header_nav_confirm_on" class="navbar-nav justify-content-end" style="display: none">
            <li class="nav-item">
              <a class="nav-link text-secondary" href="#" onclick="javascript:logout();">로그아웃</a>
            </li>
           
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">관리자</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#voteModal" data-toggle="modal">투표만들기</a>
                <a class="dropdown-item" href="#">차트보기</a>
                <a class="dropdown-item" href="#">회원관리</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- 상단 오른쪽 -->
    <!-- 상단 Header End  -->
    
    <!-- 상단 jumbotron start -->
    <div style="height: 60px;"></div>
	<div class="jumbotron jumbotron-fluid" style="margin-bottom:0px; background-image: url('./reference/img/house.jpeg');">
	  <div class="container" style="text-align: center;">
	    <h1>Happy house</h1>      
	    <p>행복한 우리 집</p>
	  </div>
	</div>
	 <!-- 상단 jumbotron end -->
	 
    <div class="container">
        <!-- 중앙 contents start -->
        <div class="row">
        	<!-- <div class="col-md-3">
       	 	<button type="button" class="btn btn-primary">Primary</button>
			<button type="button" class="btn btn-secondary">Secondary</button>
            </div> -->
            <!-- 중앙 center contents start -->
           <div class="col">
				<!-- Google Map start -->
				<div class="text-center">
					<div class="dropdown" style="margin-bottom: 30px; padding: 30px;">
						<div class="btn-group">
					    	<button type="button" id="areaBtn" class="btn btn-light dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">지역선택</button>
						    <div class="dropdown-menu">
								<label class="dropdown-item cafe_area">서울</label>
								<label class="dropdown-item cafe_area">대전</label>
								<label class="dropdown-item cafe_area">구미</label>
								<label class="dropdown-item cafe_area">광주</label>
						    </div>
					  	</div>
					  	<div class="btn-group">
					    	<button type="button" id="officeBtn" class="btn btn-light dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">지점선택</button>
						    <div id="office_div" class="dropdown-menu"></div>
					  	</div>
					</div>
				</div>
				<div id="map" style="width: 100%; height: 300px; margin: auto;"></div>
				<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQK7GHe6wBZzH95bYhJszq2eE67OQzA-w&callback=initMap"></script>
				<script>
					var multi = {lat: 37.5012743, lng: 127.039585};
					var map;
					var markers = [];
					var infoWindow;
					
					function initMap() {
						map = new google.maps.Map(document.getElementById('map'), {
							center: multi, zoom: 15
						});
						
						infoWindow = new google.maps.InfoWindow;
						
						const myposition = "img/my_position.png";
						
						var multimarker = {
								coords: multi,
								iconImage: myposition,
								content: '멀티캠퍼스(역삼)'
						};
						addMarker(multimarker);
						infoWindow.setPosition(multi);
						infoWindow.setContent('멀티캠퍼스.');
						infoWindow.open(map);
						
					}
					
					
					function handleLocationError(browserHasGeolocation, infoWindow, pos) {
						infoWindow.setPosition(pos);
						infoWindow.setContent(browserHasGeolocation ?
							'Error: Geolocation 서비스 실패.' :
							'Error: Geolocation을 지원하지 않는 브라우저.');
						infoWindow.open(map);
					}
					
					function addMarker(props) {
						const marker = new google.maps.Marker({
							position: new google.maps.LatLng(parseFloat(props.coords.lat),parseFloat(props.coords.lng)),
							map: map
						});
						map.setCenter(marker.getPosition());
						map.setZoom(15);
						
						if(props.iconImage){
							marker.setIcon(props.iconImage);
						}
	
						if(props.content){
							infoWindow = new google.maps.InfoWindow({
								content:props.content
							});
	
						}
						
						marker.addListener('click', function() {
							map.setZoom(17);
							map.setCenter(marker.getPosition());
							bounceMarker(marker);
						});
						markers.push(marker);
						setMapOnAll(map);
					}
					
					function bounceMarker(marker) {
						if (marker.getAnimation() !== null) {
							marker.setAnimation(null);
						} else {
							marker.setAnimation(google.maps.Animation.BOUNCE);
						}
					}
					
					function deleteMarkers() {
						clearMarkers();
						markers = [];
					}
					
					function clearMarkers() {
						setMapOnAll(null);
					}
					
					function setMapOnAll(map) {
						for (let i = 0; i < markers.length; i++) {
							markers[i].setMap(map);
						}
					}
				</script>
				<!-- Google Map end -->
			  <div class="btn-group" style="width: 100%; margin-top: 20px;">
			    <button type="button" class="btn btn-primary"><a href="${root}/search/dong" style="color: white;text-decoration: none;">주거공간 검색</a></button>
			    </div>
			  </div>
            </div>
            <!-- 중앙 center contents end -->
            
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

    <!-- 투표만들기 modal start -->
    <div id="voteModal" class="modal fade">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">투표 만들기</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="">
              <div class="form-group">
                <label>시작일 <input type="date" id="start_date" name="start_date" class="form-control" /></label>
                <label>종료일 <input type="date" id="end_date" name="end_date" class="form-control" /></label>
              </div>
              <div class="form-group">
                <label>질문 내용</label>
                <input type="text" id="question" name="question" class="form-control" placeholder="질문내용..." />
              </div>
              <div class="form-group">
                <label>답변 항목</label>
                <button type="button" id="addAnswerBtn" class="btn btn-outline-danger btn-sm" onclick="javascript:addAnswer();">추가</button>
              </div>
              <div id="poll_answer_list" class="form-group">
                <div class="poll_answer_item mb-1">
                  <input type="text" name="answer" class="form-control" />
                </div>
              </div>
              <div class="form-group mt-2 text-right">
                <button type="button" id="pollMakeBtn" class="btn btn-primary" onclick="javascript:makePoll();">투표 생성</button>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    <!-- 투표만들기 modal start -->
  </body>
</html>
