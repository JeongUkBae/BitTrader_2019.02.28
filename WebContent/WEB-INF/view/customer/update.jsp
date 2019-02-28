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

 	<h1><font style="font-size: 30px">검색 결과</font></h1>

<div class="grid-item" id="content">
<div class="row">

  <div class="col-xs-6">
	  <img src="${img}default-avatar.jpg" style="height: 200px; width: 100%;"/>
  </div>
  <div class="col-xs-6">
		<form id="form">
  				 아이디:  ${cust.customerID}<br />
				 이름 : ${cust.customerName}<br />
				생년월일 : ${cust.ssn}<br />
				성별 : 남 <br />
				전화번호 : <input type="text" name="phone" placeholder="${cust.phone}"/><br />
				우편번호 : <input type="text" name="postal_code" placeholder="${cust.postalcode}"/><br />
				지번주소 : <input type="text" name="city" placeholder="${cust.city}"/><br />
				상세주소 : <input type="text" name="address" placeholder="${cust.address}"/><br />
				임시비밀번호 : <input type="text" name="password" placeholder="임시비밀번호"/><br />
			   	<input type="hidden" name="customerID" value="${cust.customerID}" />
				 <input type="hidden" name="cmd" value="cust_update" />
   				 <input type="hidden" name="dir" value="customer" />
   				 <input type="hidden" name="page" value="detail" />
			
			</form>
  <div class="grid-item">
		<span id="update_access" class="label label-primary">확인</span>
		
	</div>
	  <div class="grid-item">
		<span id="update_reset" class="label label-danger">취소</span>
	</div>
  </div>
  
</div>
</div>


<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_access').attr('style','cursor:pointer').click(function(){
	 var form = $('#form');
	 form.attr('action','${ctx}/customer.do');
	 form.attr('method','post');
	 form.submit();
});
$('#update_reset').attr('style','cursor:pointer').click(function(){
	 alert('취소 클릭!');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${cust.customerID}');
});
</script>