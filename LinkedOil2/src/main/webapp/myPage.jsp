<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css" rel="mainstylesheet">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=383beb63eac8714dec4cc534f56f27f8&libraries=services"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>마이페이지-링크드오일</title>
</head>
<body>
	 <jsp:include page="header.jsp"/>
	<div>
		<h3>MY PAGE</h3>
		<ul>
			<div>
				<li>${nickname }님 :")</li>
				<li>오늘도 안전운행 하세요!</li>			
			</div>
			<div>
				<li>MY OIL</li>
				<li>${list }</li>			
			</div>
			<div>
				<li>단골 주유소</li>
				<li>2 곳</li>			
			</div>
			<div>
				<li>내가 쓴 리뷰</li>
				<li>10 개</li>			
			</div>
		</ul>
	</div>
	<div>
		<ul>
			<li><a href="#">회원정보 변경</a></li>
			<li><a href="#">관심 주유소</a></li>
			<li><a href="#">내가 쓴 리뷰</a></li>
		</ul>
	</div>
	<div>
		<form action="updateMember.do" method="post" name="loginForm" class="form">
			<div>
				<h3 class="form__title">
			  		<label for="email">아이디(이메일):</label>
			  	</h3>
			  	<div class="int_check">
			  		<input type="email" placeholder="${email }" id="email" class="form-init" name="email" readonly="readonly">
				</div>
			</div>
			<div>
				<h3 class="form__title">
			 		 <label for="pwd">비밀번호:</label>
				</h3>
				<div class="int_check">
			  		<input type="text" placeholder="*********" id="pwd" class="form-init" name="pwd" readonly="readonly">
					<input type="button" value="비밀번호 변경"  class="form__submit form__submit--sm" onclick="checkNickname(this.form)">
				</div>
			</div>
			<div>
				<h3 class="form__title">
			  		<label for="name">이름:</label>
			  	</h3>
			  	<input type="text" placeholder="${name }" id="name" class="form-init"  name="name" readonly="readonly">
			</div>
			<div>
				<h3 class="form__title">
			  		<label for="nickname">닉네임:</label>
			  	</h3>
			  	<div class="int_check">
			  		<input type="text" placeholder="${nickname }" id="nickname" class="form-init" name="nickname" readonly="readonly">
			  		<input type="button" value="닉네임 변경"  class="form__submit form__submit--sm" onclick="checkNickname(this.form)">
				</div>		
			</div>
		</form>
	</div>
</body>
</html>