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
<div class="grid-item" id="content">
	<div class="grid-item" id="content">
 	<h1><font style="font-size: 30px">검색 결과</font></h1>
	</div>

<div class="row">
  <div class="col-xs-6">
  	<div class="grid-item" id="content">
  		<form id="form"  >
	  		<img src="${img}/${image.imgName}.${image.imgExtention}" style="height: 200px; width: 200px;"/>
	  		<input type="file" name="file_upload" />
	  		<input type="submit" id="file_upload_btn" />
	  		<input type="hidden" name="cmd" value="cust_file_upload"/>
	  		<input type="hidden" name="page" value="detail"/>
	  	
	<div class="grid-item">
		<span id="photo_btn" class="label label-danger">사진 수정</span>
	</div> 
	</form>
  </div>
 
  		
  </div>
 
  <div class="col-xs-6" >
   	 <div class="grid-item" id="content">
  				아이디: <br />
				이름 : <br />
				생년월일 :<br />
				성별 : <br />
				핸드폰 :<br />
				우편번호 :<br />
				도로명 : <br />
				상세주소 : <br />
  		</div>
 	 <div class="grid-item" id="content">
  				${cust.customerID}<br />
				${cust.customerName}<br />
				${cust.ssn}<br />
				남 <br />
				${cust.phone}<br />
				${cust.postalcode}<br />
				${cust.city}<br />
				${cust.address}<br />
  		</div>
 	 </div>
	  
		<div class="grid-item">
			<span id="update_btn" class="label label-primary">수정</span>
		</div>
		<div class="grid-item">
			<span id="list_btn" class="label label-danger">리스트</span>
		</div>
		<div class="grid-item">
			<span id="remove_btn" class="label label-danger">탈퇴</span>
		</div>
		
	</div>
</div>

<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id=${cust.customerID}');
});
$('#list_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_list&page=list');
});
$('#remove_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_remove&dir=home&page=main&customer_id=${cust.customerID}');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(function(){
	 $('#form')
	 .attr('method','post')
	 .attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&customer_id=${cust.customerID}')
	 .attr('enctype','multipart/form-data')
	 .submit();
});
</script>