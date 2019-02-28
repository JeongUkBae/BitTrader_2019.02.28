<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!-- <div class="navi-bar">
	<ul class="ul_navi_bar">
		<li><a href="home.do">홈</a></li>
		<li><a href="#">마이페이지</a>
		<li><a href="customer.do">주문</a>
		<li><a href="#">사원</a></li>
		<li><a href="#">상품</a>
		<li><a href="#">선박</a>
		<li><a href="#">공급업체</a>
	</ul>
<div class="navi-bar">
	<ul class="ul_navi_bar">
	<li><a href="home.do">홈</a></li>
	</ul> 
	
</div>
</div> -->
<div class="navi-bar" id="navi-bar">
	<div class = "row" id="ul_navi_bar">
	
		<div class="col-md-1"> <ul><li><a href="home.do">Home</a> </li></ul></div>
		<div class="col-md-1"> <ul><li><a href="#">MyPage</a></li></ul> </div>
		<div class="col-md-1">  </div>
		<div class="col-md-1"> </div>
		<div class="col-md-1"> </div>
		<div class="col-md-1"> </div>
		<div class="col-md-3 col-md-offset-3">
		 	<ul><li><a href="#" class="count" >${emp.name} 님 환영합니다.</a></li></ul>
		</div>

	</div>
</div>



<script>
$('#li_nav_7').click(function(){
	alert('마이페이지 클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${cus.customerID}');
});



</script>