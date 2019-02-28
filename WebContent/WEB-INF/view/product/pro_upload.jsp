<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="navi_bar">
	<jsp:include page="../home/post-navi-bar.jsp"/>
	</div>
	
	
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">상품 등록</font></h1>
</div>


<div class="row">
  <div class="col-xs-6">
<div class="grid-item" id="content">
 	<div class="grid-item" id="content">
 	<h1>상품 정보</h1>
  		<form id="form"  >
	  		<img src="${img}/${image.imgName}.${image.imgExtention}" style="height: 380px; width: 450px;"/>
	  		<input type="file" name="file_upload" />
	  		<input type="submit" id="file_upload_btn" />
	  		<input type="hidden" name="cmd" value="pro_file_upload"/>
	  		<input type="hidden" name="page" value="detail"/>
	  	</form>
</div>
</div>
</div>

<div class="row">
  <div class="col-xs-6">
  	<div class="grid-item" id="content">
 <div>
 <form id="pro_upload_form">
  <h1>상품 정보</h1>
  
   	<div class="input-group input-group-lg">
 		
 		
 		<!--  -->
 <!-- 		<div class="dropdown">
 		 <span class="input-group-addon" id="sizing-addon1">ProductID
 		 <input type="text" class="form-control" aria-label="..." id="product_id"></input></span>
    <button class="btn btn-default dropdown-toggle" id="mystatus" value="title" type="button" data-toggle="dropdown" aria-expanded="true">
    ProductID
    <span class="caret"></span>
    </button>
    <ul id="mytype" class="dropdown-menu" role="menu" aria-labelledby="searchType">
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#" value="1000">삼성</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#" value="1001">애플</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#" value="1002">LG</a></li>
        <li class="divider"></li>
        <li><a href="#">개인 판매자</a></li>
    </ul>
</div> -->
 		<!--  -->
 		
 		
 		
 		  <div class="col-lg-6">
    <div class="input-group">
    	 <span class="input-group-addon" id="sizing-addon1">ProductID</span>
    	  <input type="text" class="form-control" aria-label="..." id="product_id" value="">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">ID List <span class="caret"></span></button>
        <ul class="dropdown-menu dropdown-menu-right" role="menu" id="select_pro_id">
          <li id="pro_id_1"><div class="grid-item" value="1000">삼성</div></li>
          <li><div class="grid-item" value="1001">애플</div></li>
          <li><div class="grid-item" value="1002">LG</div></li>
          <li><div class="grid-item" value="1003">화웨이</div></li>

        </ul>
      </div><!-- /btn-group -->
    </div><!-- /input-group -->
  </div>
 		 <!-- <input type="text" class="form-control" placeholder="ID" aria-describedby="sizing-addon1" 
  				name="customId" id="customId"/> -->
	</div>
	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">이름</span>
 		 <input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon1" 
  				name="cname" id="cname"/>
	</div>
	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">비밀번호</span>
 		 <input type="text" class="form-control" placeholder="Password" aria-describedby="sizing-addon1" 
  				name="cpassword" id="cpassword"/>
	</div>

	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">주민번호</span>
 		 <input type="text" class="form-control" placeholder="SSN" aria-describedby="sizing-addon1" 
  				name="ssn" id="ssn"/>
	</div>
		<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">전화번호</span>
 		 <input type="text" class="form-control" placeholder="phone" aria-describedby="sizing-addon1" 
  				name="phone" id="phone"/>
	</div>
		<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">사진</span>
 		 <input type="text" class="form-control" placeholder="photo" aria-describedby="sizing-addon1" 
  				name="photo" id="photo"/>
	</div>
	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">지번주소</span>
 		 <input type="text" class="form-control" placeholder="city" aria-describedby="sizing-addon1" 
  				name="city" id="city"/>
	</div>
	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">상세주소</span>
 		 <input type="text" class="form-control" placeholder="Address" aria-describedby="sizing-addon1" 
  				name="addr" id="addr"/>
	</div>

	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">우편번호</span>
 		 <input type="text" class="form-control" placeholder="pcode" aria-describedby="sizing-addon1" 
  				name="pcode" id="pcode"/>
	</div>
  <div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="confirm_btn">등록</button>
      </span>
          <span class="input-group-btn">
        <button class="btn btn-default" type="reset" id="cancel_btn">취소</button>
      </span>
    </div>
   </div>
  
</div>
	<input type="hidden" name="cmd" value="signup" />
	<input type="hidden" name="page" value="signin" />
</form>
</div>
</div>
</div>
 </div>
</div>
<jsp:include page="../home/bottom.jsp"/>
    <script>
 		 $('#confirm_btn').click(function(){
 			var customId = $('#customId').val();
 			var cname = $('#cname').val();
 			var cpassword = $('#cpassword').val();
 			var ssn = $('#ssn').val();
 			var phone = $('#phone').val();
 			var photo = $('#photo').val();
	  		var city = $('#city').val();
	  		var addr = $('#addr').val();
	  		var pcode = $('#pcode').val();
	  		
	  		$('#signup_form').attr('action','${ctx}/customer.do').submit;
 		});
 		 
 		 
	  	$('#pro_id_1').attr('style','cursor:pointer').on('click', function() {
	  		   // 버튼에 선택된 항목 텍스트 넣기 
	  		    $('#product_id').text($(this).text());
	  		  alert($(this).attr('value'));
		});
	  	
	  	/*  */
	  	
	  	$('#mytype li > a').on('click', function() {
    // 버튼에 선택된 항목 텍스트 넣기 
   			 $('#select_pro_id').text($(this).text());
        
    // 선택된 항목 값(value) 얻기
   		 	alert($(this).attr('value'));
    		
		});

  </script>


 <!-- employeeID, manager,name, birthDate, photo, notes-->