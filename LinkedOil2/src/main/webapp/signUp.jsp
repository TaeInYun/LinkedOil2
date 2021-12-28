<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//회원가입 화면의 입력값 검사
	function checkvalue(){
		
		if(form.idDuplication.value != "idCheck"){
			alert
		}
		
	}
</script>
</head>
<body>
	<h3>LINKED OIL</h3>
	<form action="inputMemberOK.jsp" method="post">
		<div class="form-group">
		  <label for="email">이메일:</label>
		  <input type="email" class="form-control" placeholder="이메일을 입력해주세요" id="email" onkeydown="inputIdCheck()" required="required">
		  <input type="button" class="btn btn-primary" value="중복확인" onclick="checkId()">
		  <input type="hidden" name="idDuplication" value="idUncheck">
		</div>
		<div class="form-group">
		  <label for="pwd">비밀번호:</label>
		  <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="pwd" required="required">
		</div>
		<div class="form-group">
		  <label for="pwd2">비밀번호 확인:</label>
		  <input type="password" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요" id="pwd2" required="required">
		</div>
		<div class="form-group">
		  <label for="name">이름:</label>
		  <input type="text" class="form-control" placeholder="이름을 입력해주세요" id="name" required="required">
		</div>
		<div class="form-group">
		  <label for="nickname">닉네임:</label>
		  <input type="text" class="form-control" placeholder="사용하실 닉네임을 입력해주세요" id="nickname" required="required">
		  <button type="submit" class="btn btn-primary">중복확인</button>
		</div>
		<div class="form-group">
		  <label for="myOil">MY 유종:</label>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="gas">휘발유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="diesel">경유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="lpg">LPG
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="premium_gas">고급휘발유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="yososu">요소수
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="electricity">전기
			  </label>
			</div>
			<p> MY 유종은 마이페이지에서 설정 가능합니다. </p>
		</div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>