<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<form name="myFrm" action="employee.do" method="post">
		<label>사원번호:</label>
		<input type="number" name="eid"> <br> 
		<label>LastName:</label>
		<input type="text" name="last_name"> <br>
		<label>email:</label>
		<input type="email" name="email"> <br>
		<label>입사일자:</label>
		<input type="date" name="hire_date"> <br>
		<label>직무:</label>
		<select name="job">
			<option value="IT_PROG">개발자</option>
			<option value="SA_REP">영업사원</option>
			<option value="SA_MAN">영업팀장</option>
		</select> <br>
		<input type="submit" value="전송">
		<input type="button" value="조회" onclick="empGetFnc()">
		
		<a href="empList.do">조회</a>
	</form>
	<script>
		function empGetFnc() {
			document.forms.myFrm.method = "get";
			document.forms.myFrm.action = "empList.do";
			document.forms.myFrm.submit();
		}
	</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>