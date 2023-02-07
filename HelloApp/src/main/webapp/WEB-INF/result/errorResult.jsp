<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>

	<h1>처리 중 에러가 발생했습니다!</h1>
	<h3>Expression Language (EL)</h3>
	<p>${3>5 }</p>
	<p>${'test'=='test'}</p>
	<p>${5-4 }</p>
	<p>${id }EL안에서 ${id} => getAttribute()</p>
	<p>${id eq null }</p>
	<p>${empty id }</p>
	<p>${obj }</p>
	<p>ID: ${obj.memberId }</p>
	<p>Name: ${obj.memberName }</p>
	<p>List: ${empList }</p>
	<p>html안에 자바코드 제거 => jstl</p>
	
	<c:set var="myname" value="홍길동"></c:set>
	<c:out value="${myname }"></c:out> <!-- 출력문 -->
	<p>${myname }</p>
	
	<c:set var="score" value="70"></c:set>
	<c:if test="${score > 60 }">
		<p>합격</p>
	</c:if>
	<c:if test="${score < 60 }">
		<p>불밯격</p>
	</c:if>
	
	<c:choose>
		<c:when test="${score > 90 }"><p>A학점</p></c:when>
		<c:when test="${score > 80 }"><p>B학점</p></c:when>
		<c:when test="${score > 70 }"><p>C학점</p></c:when>
		<c:otherwise><p>D학점</p></c:otherwise>
	</c:choose>
	
	<c:forEach begin="1" end="10" var="num">
		<p class='<c:out value="${num }" />'>${num }</p>
	</c:forEach>
	
	<p>3단 출력하기</p>
	<c:set var="dan" value="4"></c:set>
	<c:forEach begin="1" end="9" var="i">
	 <p> ${dan} x ${i } = ${dan*i }</p>
	</c:forEach>
	
	<c:forEach items="${empList }" var="emp">
		<p>사번: ${emp.employeeId }, 이름:${emp.firstName }, 이메일:${emp.email }, 직무:${emp.jobId }</p>
	</c:forEach>
	
	<br>
	<a href="empForm.do">입력창으로</a>
<jsp:include page="../includes/footer.jsp"></jsp:include>