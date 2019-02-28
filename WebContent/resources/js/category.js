var ctx = "${ctx}";
$('.count').attr('style','cursor:pointer').click(()=>{
	location.assign(ctx+'/customer.do?cmd=cust_list&page=list&page_size=5&page_num='+$(this).text());
}); 

$('#product').attr('style','cursor:pointer').click(()=>{
	location.assign('${ctx}/product.do?cmd=pro_list&page=main');
}); 

$('#cate_register').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_register').attr('style','background-color: #757575');
	$('#content').html(
			+' <form id="form" class="form">'
			+'  <div class="form-group" >'
			+'    <label for="text">카테고리 이름:</label> '
			+'    <input type="text" class="form-control" name="cate_name" id="cate_name" style="width: 350px"> '
			+'  </div>'
			+'  <div class="form-group"> '
			+'    <label for="text">상세 설명:</label> '
			+'    <input type="text" class="form-control" name="description" id="description" style="width: 350px"> '
			+'  </div>'
			+'  <button type="submit" class="btn btn-default" id=cate_register_btn>Submit</button> '
			+'		 <input type="hidden" name="cmd" value="cate_register" />'
			+'       <input type="hidden" name="dir" value="category" />'
			+'       <input type="hidden" name="page" value="list" />'
			+'</form> '
		   		
			
			);

		
});
 $('.btn btn-default').click(()=>{
	 alert('등록클릭');
	var cetegoryneme = $('#cate_name').val();
	var description = $('#description').val();
	 $('#form').attr('action','${ctx}/category.do').submit(); 
});


$('#cate_list').click(()=>{
	location.assign('${ctx}/category.do?cmd=cate_list&page=list');
});


$('#cate_search').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_search').attr('style','background-color: #757575');
	$('#content').html('<form id="form" > '
			+'  <div class="form-group" >'
			+'    <label for="text">카테고리 검색:</label> '
			+'    <select>'
			+'		<option name="cate_id" value="1000">스마트폰</option>'
			+'		<option name="cate_id" value="1001">데스크탑</option>'
			+'		<option name="cate_id" value="1002">노트북</option>'
			+'    </select>'
			+'  <button type="submit" class="btn btn-default" id=cate_register>Submit</button> '
			+'</form> ');
});
$('#cate_update').click(()=>{

	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_update').attr('style','background-color: #757575');
	$('#content').html('<div>'
			+'    <label for="text">카테고리 검색:</label><br> '
			+'  <input type="radio" name="gender" value="1000"> 스마트폰<br>'	
			+'  <input type="radio" name="gender" value="1001"> 데스크탑<br>'
			+'  <input type="radio" name="gender" value="1002"> 노트북<br>'
			+'  </div>'
	 		+'  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">선택</button>' 
			+'		<div class="container">	'
			+'      <div class="modal fade" id="myModal" role="dialog">'
		    +'		<div class="modal-dialog">'
			+'		<div class="container">'
			+'      <div class="modal-content" style="width: 400px">'
			+'        <div class="modal-header">'
			+'          <button type="button" class="close" data-dismiss="modal">&times;</button>'
			+'          <h4 class="modal-title">카테고리 수정</h4>'
			+'        </div>'
			+'        <div class="modal-body" style="width: 400px">'
			+'          <p> '
			+  					'<form id="form" > '
			+'					  <div class="form-group" >'
			+' 					   <label for="text">카테고리 이름:</label> '
			+'  			  <input type="text" class="form-control" name="cate_name" > '
			+' 				 </div>'
			+' 				 <div class="form-group"> '
			+'  				  <label for="text">상세 설명:</label> '
			+'  			  <input type="text" class="form-control" name="description" > '
			+' 				 </div>'
			+' 				 <button type="submit" class="btn btn-default" id=cate_register_btn >Submit</button> '
			+'				</form> '
			+'			</p>'
			+'        </div>'
			+'        <div class="modal-footer">'
			+'          <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>'
			+'        </div>'
			+'      </div>'
			+'    </div>'
			+'  </div>'
			+'</div>');

});


$('#cate_delete').click(()=>{
	$('#cate_side_menu > li').attr('style','background-color: white');
	$('#cate_delete').attr('style','background-color: #757575');
	$('#content').html('<form id="form" > '
			+'  <div class="form-group" >'
			+'    <label for="text">카테고리 삭제:</label> <br>' 
			+'		<input type="checkbox" name="vehicle1" value="1000"> 스마트폰<br>'
			+'		<input type="checkbox" name="vehicle2" value="1001"> 데스크탑<br>'
			+'		<input type="checkbox" name="vehicle3" value="1003"> 노트북<br>'
			+'  <button type="submit" class="btn btn-default" id=cate_register>Submit</button> '
			+'</form> ');
});

