<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/styles.css">
<title>회원가입-링크드오일</title>
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
	<div class="header">
		<a href="start.jsp"><img class="logo" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<form action="insertMember.do" method="post" name="loginForm" class="form">
		<div>
			<h3 class="form__title">
		  		<label for="email">아이디(이메일):</label>
		  	</h3>
		  	<div class="int_check">
		  		<input type="email" placeholder="이메일을 입력해주세요" id="email" class="form-init" name="email" required="required">
		  		<input type="button" value="중복 확인" class="form__submit form__submit--sm" onclick="checkEmail(this.form)">
			</div>
		</div>
		<div>
			<h3 class="form__title">
		 		 <label for="pwd">비밀번호:</label>
			</h3>
		  	<input type="password" placeholder="비밀번호를 입력해주세요"  class="form-init" id="pwd" name="pwd" required="required">
		</div>
		<div>
			<h3 class="form__title">
		  		<label for="pwd2">비밀번호 확인:</label>
		  	</h3>
		  	<input type="password"  placeholder="비밀번호를 한번 더 입력해주세요" class="form-init" id="pwd2" required="required">
		</div>
		<div>
			<h3 class="form__title">
		  		<label for="name">이름:</label>
		  	</h3>
		  	<input type="text" placeholder="이름을 입력해주세요" id="name" class="form-init"  name="name" required="required">
		</div>
		<div>
			<h3 class="form__title">
		  		<label for="nickname">닉네임:</label>
		  	</h3>
		  	<div class="int_check">
		  		<input type="text" placeholder="사용하실 닉네임을 입력해주세요" id="nickname" class="form-init" name="nickname" required="required">
		  		<input type="button" value="중복 확인"  class="form__submit form__submit--sm" onclick="checkNickname(this.form)">
			</div>		
		</div>
		<div >
			<h3 class="form__title">
		  		<label for="myOil">MY 유종:</label>
		  	</h3>
		  	<div class="checkbox">
				<input type="checkbox"  name="myOil" id="B027" value="B027">
				<label for="B027">휘발유</label>
				<input type="checkbox" name="myOil" id="D047" value="D047">
				<label for="D047">경유</label>
				<input type="checkbox"  name="myOil" id="K015" value="K015">
				<label for="K015">LPG</label>
				<input type="checkbox" name="myOil" id="B034" value="B034">
				<label for="B034">고급휘발유</label>
				<input type="checkbox" name="myOil" id="Y000" value="Y000">
				<label for="Y000">요소수</label>
				<input type="checkbox" name="myOil" id="E001" value="E001">
				<label for="E001">전기</label>
			</div>
			<p class="form__msg"> *MY 유종은 마이페이지에서 설정 가능합니다. </p>
		</div>
		<input type="button" value="회원가입" class="form__submit" onclick="checkForm()">
	</form>
</body>
</html>
