<%@page import="com.yedam.emp.service.EmpServiceImpl"%>
<%@page import="com.yedam.emp.*"%>
<%@page import="com.yedam.emp.vo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<%
		EmpServiceImpl service = new EmpServiceImpl();
		List<EmpVO> list = service.empList();
	%>
	<h3>사원목록(EmpControl.do의 결과 페이지)</h3>
	<table class ='table'>
		<thead>
			<tr>
				<th>사원번호</th>
				<th>LastName</th>
				<th>email</th>
				<th>입사일자</th>
				<th>직무</th>
			</tr>
		</thead>
		<tbody>
			<% for (EmpVO emp : list) { %> 
					<tr>
						<td><a href="empDetail.do?eid=<%=emp.getEmployeeId() %>"><%=emp.getEmployeeId() %></a></td>
						<td><%=emp.getLastName() %></td>
						<td><%=emp.getEmail() %></td>
						<td><%=emp.getHireDate() %></td>
						<td><%=emp.getJobId() %></td>
					</tr>
			<% } %>
		</tbody>
	</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>