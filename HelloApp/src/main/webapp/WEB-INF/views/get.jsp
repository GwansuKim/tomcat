<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>form 요청 get/post</h3>
	<form action='../login.do' method='post'>
		<label> ID <input type="text" name="uid" value="user1">
		</label> <br> <label> PW <input type="password" name="upw" value="1234">
		</label> <br> <input type="submit" value="전송">
	</form>
	<br>
	<a href="../login.do?uid=user1&upw=1234">로그인</a>
	//링크는 무조건 get방식
	<script>
		fetch("../login.do", {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: 'uid=user1&upw=1234'
		})
		.then(resolve => resolve.text())
		.catch(reject => console.log(reject))
	</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>