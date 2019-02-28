<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="top.jsp"/>
    <link rel="stylesheet" href="${css}/home/main.css" />
	<div class="grid-contect-container">
	  <div class="grid-item" id="item1"><b>고객 전용</b><br>
	    <a href="#" id="cust_join">회원가입</a>
	    <a href="#" id="cust_login">로 그 인</a><br>
	  </div>
	  <div class="grid-item" id="item2"><b>직원 전용</b><br>
	    <a href="#" id="emp_register">사원 등록</a>
	    <a href="#" id="emp_access">접속 요청</a><br>
	  </div>
	  
	  
	  
	  <div class="grid-item" id="item2"><b>객체지향</b><br>
	    <a href="#" id="oop_access">접속하기</a>

	  </div>
	  	  <div class="grid-item" id="item2"><b>알고리즘</b><br>
	    <a href="#" id="algo_access">접속하기</a>

	  </div>
	</div>

<jsp:include page="bottom.jsp"/>
<script src="${js}/oop.js"></script>
<script>
	$('#cust_join').click(function(){
		location.assign('customer.do?cmd=move&page=signup');
	});
	$('#cust_login').click(function(){
		location.assign('customer.do?cmd=move&page=signin');
	});

	$('#emp_register').click(function(){
		location.assign('employee.do?cmd=move&page=register');
	});
	$('#emp_access').click(function(){
		location.assign('employee.do?cmd=move&page=access');
	});
	
	$('#oop_access').click(function(){
		//encap.main();
		//inherit.main();
		test.main();
	});
	$('#algo_access').click(function(){
		
	});
</script>