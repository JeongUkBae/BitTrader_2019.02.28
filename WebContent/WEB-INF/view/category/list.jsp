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
	
 <div class="grid" id="side-menu">
  <div class="col-xs-1">
  	
  <div class="grid-item" id="side-menu">
  			 <div class="list-group" style="width: 200px" id="cate_side_menu22">
  			<h2>카테고리 메뉴</h2>
				<ul id="cate_side_menu">
					<li class="list-group-item" id="cate_list" style="background-color: #757575">카테고리 목록</li>
					<li class="list-group-item" id="cate_register" >카테고리 등록</li>
					<li class="list-group-item" id="cate_search" >카테고리 조회</li>
					<li class="list-group-item" id="cate_update" >카테고리 수정</li>
					<li class="list-group-item" id="cate_delete" >카테고리 삭제</li>
				</ul>
 			 </div>
		</div>
  
  </div>
     
		
<div class="grid" id="side-menu" >
<div class="grid-item" id="content" >
<div class="col-xs-6">
		<h1><font style="font-size: 30px">카테고리 리스트 </font></h1>

	<table id="cate_tab" style="width: 500px" >
	  <tr >
	    <th>No.</th>
	    <th>카테고리 제목</th>
	    <th>카테고리 설명</th>
	  </tr>
	  <c:forEach items="${list}" var="category">
	  <tr>
	    <td>${category.categoryID}</td>
	    <td>${category.categoryName}</td>
	    <td><a href="#">${category.description}</a></td>
	  </tr>
	    </c:forEach>
	
	</table>
	</div>
   
   </div>
  </div>	
  </div>

<%-- 	<div class="center">
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
	  
	</div> --%>
		


<jsp:include page="../home/bottom.jsp"/>
<script src="${js}/category.js }">


</script>