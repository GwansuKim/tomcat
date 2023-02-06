<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
Map<String, String> list = (Map<String, String>) request.getAttribute("jobList"); // Object -> (EmpVO)
%>
<form name="myFrm" action="employee.do" method="post">
	<table class="table">
		<tr>
			<th>사원번호</th>
			<td><input type="number" name="eid"></td>
		</tr>
		<tr>
			<th>LastName</th>
			<td><input type="text" name="last_name"></td>
		</tr>
		<tr>
			<th>email</th>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<th>입사일자</th>
			<td><input type="date" name="hire_date"></td>
		</tr>
		<tr>
			<th>직무</th>
			<td>
				<select name="job">
					<%
					for (Entry<String, String> ent : list.entrySet()) {
					%>
					<option value="<%=ent.getKey()%>"><%=ent.getValue()%></option>
					<%
					}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-primary">등록</button>
				<input type="button" class="btn btn-primary" value="조회" onclick="empGetFnc()">
			</td>
		</tr>
	</table>
</form>
<script>
	function empGetFnc() {
		document.forms.myFrm.method = "get";
		document.forms.myFrm.action = "empList.do";
		document.forms.myFrm.submit();
	}
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>