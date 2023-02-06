<%@page import="java.util.*"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.yedam.emp.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
EmpVO emp = (EmpVO) request.getAttribute("searchVO");
Integer age = (Integer) request.getAttribute("myAge");
String id = (String) request.getAttribute("loginId");
%>
<%=age%>,
<%=id%>
<%
Map<String, String> list = (Map<String, String>) request.getAttribute("jobList"); // Object -> (EmpVO)
%>
<h3>현재 페이지는 empModForm.do의 결과 modify.jsp 입니다</h3>
<form name="myFrm" action="empModify.do" method="post">
	<table class="table">
		<tr>
			<th>사원번호</th>
			<td><%=emp.getEmployeeId()%><input type="hidden" name="eid" value="<%=emp.getEmployeeId()%>"></td>
		</tr>
		<tr>
			<th>LastName</th>
			<td><input type="text" name="last_name"
				value="<%=emp.getLastName()%>"></td>
		</tr>
		<tr>
			<th>email</th>
			<td><input type="email" name="email" value="<%=emp.getEmail()%>"></td>
		</tr>
		<tr>
			<th>입사일자</th>
			<td><input type="date" name="hire_date"
				value="<%=emp.getHireDate()%>"></td>
		</tr>
		<tr>
			<th>직무</th>
			<td><select name="job">
		<%
		for (Entry<String, String> ent : list.entrySet()) {
		%>
		<option value="<%=ent.getKey()%>"><%=ent.getValue()%></option>
		<%
		}
		%>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-primary">변경</button>
				<button type="button" class="btn btn-warning" onclick="location.href='empRemove.do?id=<%=emp.getEmployeeId()%>'">삭제</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>