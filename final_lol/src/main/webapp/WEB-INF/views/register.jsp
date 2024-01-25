<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register page</title>
</head>
<body>
    <h1>회원가입 page</h1>
    <form action="/register" id="registerForm">
    
      
      <input type="text" id="ireum" name="ireum" placeholder="이름" required><br>
   
      <input type="text" id="username" name="username" oninput="checkId()" placeholder="아이디" required><br>
      <span id="idCheckMessage"></span>
      
      <input type="text" id="nickname" name="nickname" placeholder="닉네임" required><br>
    
      
      <input type="password" id="userpwd" name="userpwd" placeholder="비밀번호 " required><br>
      <input type="password" id="confirm_pwd" name="confirm_pwd" placeholder="비밀번호 재입력" required><br>
   
      <label for="gender">성별:</label>
      <select id="gender" name="gender" required>
          <option value="male">남성</option>
          <option value="female">여성</option>
      </select>
      <br>
      <button class="button register-button" type="button" onclick="register()">가입하기</button>
   
    </form>
    
    <script>
    function register() {
        let username = document.getElementById("username").value;
        let userpwd = document.getElementById("userpwd").value;
        let confirmpwd = document.getElementById("confirm_pwd").value;

        // 아이디 유효성 검사
        if (!/^[a-zA-Z0-9]{3,}$/.test(username)) {
            alert("아이디는 3자 이상의 영문/숫자로 입력해주세요.");
            return;
        }

        // 비밀번호 유효성 검사
        if (userpwd !== confirmpwd) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        alert("회원가입이 완료되었습니다!");
        document.querySelector('form').submit();
    }

    function checkId() {
        let username = document.getElementById("username").value;
        let idCheckMessageElement = document.getElementById("idCheckMessage");

        // 아이디 길이 검사
        if (username.length < 3) {
            idCheckMessageElement.innerText = "아이디는 3자 이상이어야 합니다.";
            idCheckMessageElement.style.color = "red";
            return;
        }

        // 아이디 유효성 검사 (영문 대소문자, 숫자 조합)
        if (!/^[a-zA-Z0-9]+$/.test(username)) {
            idCheckMessageElement.innerText = "영문 대소문자와 숫자만 사용 가능합니다.";
            idCheckMessageElement.style.color = "red";
            return;
        }

        // 비동기 fetch 함수, register 함수 내에서 선언한 checkId 함수
        fetch('/register/checkId?username=' + username)
            .then(response => response.json())
            .then(data => {
                if (data.isDuplicated) {
                    idCheckMessageElement.innerText = "이 아이디는 이미 사용 중입니다.";
                    idCheckMessageElement.style.color = "red";
                } else {
                    idCheckMessageElement.innerText = "사용 가능한 아이디입니다.";
                    idCheckMessageElement.style.color = "green";
                }
            });
    }
    </script>
</body>
</html>
