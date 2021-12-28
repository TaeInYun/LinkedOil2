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
	function checkForm(){
		var email = document.getElementById('email').value;
		var form = document.getElementsByClassName("form-group");
		
		var pwd = document.getElementById("pwd").value;
		var pwd2 = document.getElementById("pwd2").value;
		var regExp_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		if(!regExp_email.test(email)){
			alert("올바른 이메일 형식이 아닙니다.");
			return false
		}
		
		//비밀번호와 비밀번호확인의 값이 동일한가
		if(pwd != pwd2){
			alert("비밀번호를 동일하게 입력해주세요.");
			return false;
		}
		
		document.loginForm.submit();
	}
	
	function checkEmail(){
		var regExp_email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var email = document.getElementById('email').value;

		if(!regExp_email.test(email)){
			alert("올바른 이메일 형식이 아닙니다.");
			return false
		}
		
		url = "confirmId.do?email=" + email;
		open(url, "confirm", "toolbar=no, location=no, status=no, menubar=no scrollbar=no, resizable=no,width=300,height=200");
	}
	
	function checkNickname(){
		var nickname = document.getElementById('nickname').value;
		
		url = "confirmNickname.do?nickname=" + nickname;
		open(url, "confirm", "toolbar=no, location=no, status=no, menubar=no scrollbar=no, resizable=no,width=300,height=200");
	}
</script>
</head>
<body>
	<h3>LINKED OIL</h3>
	<form action="insertMember.do" method="post" name="loginForm">
		<div class="form-group">
		  <label for="email">아이디(이메일):</label>
		  <input type="email" class="form-control" placeholder="이메일을 입력해주세요" id="email"  name="email" required="required">
		  <input type="button" class="btn btn-primary" value="중복확인" onclick="checkEmail(this.form)">
		</div>
		<div class="form-group">
		  <label for="pwd">비밀번호:</label>
		  <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="pwd" name="pwd" required="required">
		</div>
		<div class="form-group">
		  <label for="pwd2">비밀번호 확인:</label>
		  <input type="password" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요" id="pwd2" required="required">
		</div>
		<div class="form-group">
		  <label for="name">이름:</label>
		  <input type="text" class="form-control" placeholder="이름을 입력해주세요" id="name" name="name" required="required">
		</div>
		<div class="form-group">
		  <label for="nickname">닉네임:</label>
		  <input type="text" class="form-control" placeholder="사용하실 닉네임을 입력해주세요" id="nickname" name="nickname" required="required">
		  <input type="button" class="btn btn-primary" value="중복확인" onclick="checkNickname(this.form)">
		</div>
		<div class="form-group">
		  <label for="myOil">MY 유종:</label>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="B027">휘발유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="D047">경유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="K015">LPG
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="B034">고급휘발유
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="Y000">요소수
			  </label>
			</div>
			<div class="form-check-inline">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" name="myOil" value="E001">전기
			  </label>
			</div>
			<p> MY 유종은 마이페이지에서 설정 가능합니다. </p>
		</div>
		<input type="button" value="회원가입" onclick="checkForm()">
	</form>
</body>
</html>