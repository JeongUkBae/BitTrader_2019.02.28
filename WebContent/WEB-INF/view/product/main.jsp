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
 	<h1><font style="font-size: 30px">상품 리스트</font></h1>
</div>
 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<div>
        <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
     </div>

      	<ul class="nav navbar-nav navbar-right">
		  <li role="presentation" class="active" id="pro_upload"><a href="#">상품등록</a></li>
		  <li role="presentation"><a href="#">선택수정</a></li>
		  <li role="presentation"><a href="#">선택삭제</a></li>
    	</ul>
    	
  
 </div>
<div class="grid-item" id="content">
	
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>제품 번호</th>
	    <th>제  품  명</th>
	    <th>공  급  자</th>
	    <th>카테 고리</th>
	    <th>상품 재고</th>
	    <th>가       격</th>
	    <th>상품이미지</th>
	    <th></th>
	    <th></th>
		
	  </tr>
	<%--   <c:forEach items="${list}" var="cust"> --%>
	  <tr>
	    <td>1	</td>
	    <td>1000	</td>
	    <td>갤럭시s10_32G	</td>
	    <td>삼성전자	</td>
	    <td>휴대폰	</td>
	    <td>32	</td>
	    <td>1,000,000	</td>
	    <td>default	</td>
	    <td>수정	</td>
	    <td>삭제	</td>
	  </tr>
	   <%--  </c:forEach> --%>
	
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

$('#pro_upload').attr('style','cursor:pointer').click(function(){
	alert('상품등록 클릭');
	location.assign('${ctx}/product.do?cmd=move&page=pro_upload&page_size=5&page_num='+$(this).text());
})

</script>