<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/employee/register.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">회원 등록</font></h1>
</div>
 <div>
 <form id="signup_form">
  <h1>회원정보</h1>
  
   	<div class="input-group input-group-lg">
 		 <span class="input-group-addon" id="sizing-addon1">ID</span>
 		 <input type="text" class="form-control" placeholder="ID" aria-describedby="sizing-addon1" 
  				name="customId" id="customId"/>
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
	  		
// 	  		if(empno === ''||ename === ''||
//	  				emag === ''||ebd === ''){
//	  			alert('필수 입력값이 없습니다.');	
//	  		} else  {
//	  			alert('else 로 넘어왔다~.');
//	  			$('#register_form').attr('action','${ctx}/employee.do').submit;
//	  		}
// 			});

//  		$('#cancel_btn').click(function(){
//  			alert('취소버튼 클릭'); 
 // 			});   */
  </script>


 <!-- employeeID, manager,name, birthDate, photo, notes-->