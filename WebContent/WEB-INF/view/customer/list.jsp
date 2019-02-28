<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<link rel="stylesheet" href="${css}/customer/navi_bar.css" />
<div class="grid-item" id="navi_bar">
	<jsp:include page="../home/post-navi-bar.jsp"/>
	</div>
<div class="grid-item" id="side_menu" >
 	<h1><font style="font-size: 30px">고객 리스트</font></h1>
</div>

<div class="grid-item" id="content">

	
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>아이디</th>
	    <th>이    름</th>
	    <th>생년월일</th>
	    <th>성    별</th>
	    <th>전화번호</th>
	    <th>우편번호</th>
	    <th>지번주소</th>
	    <th>상세주소</th>
		
	  </tr>
	  <c:forEach items="${list}" var="cust">
	  <tr>
	    <td>${cust.count}</td>
	    <td>${cust.customerID}</td>
	    <td><a href="${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${cust.customerID}">${cust.customerName}</a></td>
	    <td>${cust.ssn}</td>
	    <td>남자</td>
	    <td>${cust.phone}</td>
	    <td>${cust.postalcode}</td>
	    <td>${cust.city}</td>
	    <td>${cust.address}</td>
	  </tr>
	    </c:forEach>
	
	</table>
	
	<div class="center">
		  <div class="pagination">
		  <c:if test="${pagination.existPrev}">
		    <a href='${ctx}/customer.do?cmd=cust_list&page=list&page_size=5&page_num=${pagination.prevBlock}'>&laquo;</a>
		  </c:if>
		
		  <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
		  	<c:choose>
		  		<c:when test="${pagination.pageNum eq status.index}">
		  			<a href="#" class="count active" >${status.index}</a>
		  		</c:when>
		  		<c:otherwise>
		  			<a href="#" class="count" >${status.index}</a>
		  		</c:otherwise>
		  	</c:choose>
		  
		  </c:forEach>
		  
		  <c:if test="${pagination.existNext}">
		  <a href='${ctx}/customer.do?cmd=cust_list&page=list&page_size=5&page_num=${pagination.nextBlock}'>&raquo;</a>
		  </c:if>
	</div>
	  
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
/* $('.list_count').click(function(){
	 alert('클릭한페이지'+$(this).text());
	 location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num=2');
}); */
$('.count').attr('style','cursor:pointer').click(function(){
	 alert('클릭한페이지'+$(this).text());
	location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_size=5&page_num='+$(this).text());
}); 

$('#product').attr('style','cursor:pointer').click(function(){
	 alert('클릭한페이지'+$(this).text());
	location.assign('${ctx}/product.do?cmd=pro_list&page=main');
}); 
	 //page_num, page_size, cmd, dir, page
	 // ?cmd=list&page=list&page_num=2
	 /* 
	<input type="hidden" name="cmd" value="access" />
    <input type="hidden" name="dir" value="customer" />
    <input type="hidden" name="page" value="list" />
	 
	 */
</script>