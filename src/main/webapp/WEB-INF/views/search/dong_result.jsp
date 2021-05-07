<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY-글목록</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		function movewrite() {
			location.href="${root}/main?act=mvwrite";
		}
		
		function searchArticle() {
			if(document.getElementById("word").value == "") {
				alert("모든 목록 조회!!");
			}
			document.getElementById("searchformdong").action = "${root}/search/dong";
			document.getElementById("searchformdong").submit();
		}
		
		function aptLocationMark(name, lat, lng) {
			var selOffice = name;
			$("#officeBtn").text(selOffice);
			deleteMarkers();
			var officemarker = {
					coords: {lat: lat, lng: lng},
					iconImage: null,
					content: selOffice
			};
			addMarker(officemarker);
		}
		</script>
	</head>
	<body>	
	<div class="container" align="center">
		<div class="col-lg-8" align="right">
		<strong>${userinfo.username}</strong>님 환영합니다.
		<a href="${root}/user/logout">로그아웃</a>
		</div>
	  <div class="col-lg-8" align="center">
	  <h2>아파트 정보 검색</h2>
	  <p>아파트 명 / 동별 검색</p>  
	  <form id="searchformdong" method="get" class="form-inline" action="">
	  <input type="hidden" name="act" id="act" value="aptinfo">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="name" selected="selected">아파트이름</option>
			    <option value="dong">동</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력" name="word" id="word">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchArticle();">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	  <c:if test="${apts.size() != 0}">
		  <div class="container">
			<div class="row">
				<div class="col-sm-6">
					<c:forEach var="aptinfo" items="${apts}">
					  <table class="table table-active" onclick="javascript:aptLocationMark('${aptinfo.aptName}', '${aptinfo.lat}', '${aptinfo.lng}');">
					    <tbody>
					      <tr class="table-info">
					        <td>아파트 이름 : ${aptinfo.aptName}</td>
					        <td align="right">법정동 : ${aptinfo.dong}</td>
					      </tr>
					      <tr>
					        <td colspan="2" class="table-danger"><strong>거래가: ${aptinfo.dealAmount}</strong></td>
					      </tr>
					      <tr>
					        <td colspan="2" class="table-danger"><strong>거래유형: 아파트 매매 </strong></td>
					      </tr>
					      <tr>
					        <td colspan="2" class="table-danger"><strong>거래일: ${aptinfo.dealYear} / ${aptinfo.dealMonth} /${aptinfo.dealDay}</strong></td>
					      </tr>
					      <tr>
					        <td colspan="2">총면적: ${aptinfo.area}</td>
					      </tr>
					    </tbody>
					  </table>
				  	</c:forEach>
				</div>
				<div class="col-sm-6">
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
				</div>
			</div>
	  	</div>
	  </c:if>
	  <c:if test="${apts.size() == 0}">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>검색 결과가 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  </c:if>
	  </div>
	</div>
	</body>
</html>