package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CategoryDTO;
import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	
	public CreateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("===== !. Create커맨더 진입 =====");
		System.out.println("cmd::"+request.getParameter("cmd"));
		System.out.println("dir::"+request.getParameter("dir"));
		System.out.println("page::"+request.getParameter("page"));
		/*
		 * setAction(request.getParameter("cmd"));
		 * setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		 * setPage(request.getParameter("page")); 
		 * execute();
		 */
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER :
				EmployeeDTO emp = new EmployeeDTO();
				emp.setName(request.getParameter("ename"));
				emp.setManager(request.getParameter("emag"));
				emp.setBirthDate(request.getParameter("ebd"));
				emp.setPhoto(request.getParameter("ephoto"));
				emp.setNotes(request.getParameter("notes"));
				EmployeeServiceImpl.getInstance().registEmployee(emp);
			break;
		case SIGNUP : 
			/*
			 * $('#confirm_btn').click(function(){ var customId = $('#customId').val(); var
			 * cname = $('#cname').val(); var cpassword = $('#cpassword').val(); var ssn =
			 * $('#ssn').val(); var phone = $('#phone').val(); var photo =
			 * $('#photo').val(); var addr = $('#addr').val(); var city = $('#city').val();
			 * var pcode = $('#pcode').val();
			 */
				CustomerDTO cus = new CustomerDTO();
				cus.setCustomerID(request.getParameter("customId"));
				cus.setCustomerName(request.getParameter("cname"));
				cus.setPassword(request.getParameter("cpassword"));
				cus.setSsn(request.getParameter("ssn"));
				cus.setPhone(request.getParameter("phone"));
				cus.setPhoto(request.getParameter("photo"));
				cus.setCity(request.getParameter("city"));
				cus.setAddress(request.getParameter("addr"));
				cus.setPostalcode(request.getParameter("pcode"));
				
				CustomerServiceImpl.getInstance().registCustomer(cus);
			break;	
		case CATE_REGISTER:
				CategoryDTO cate = new CategoryDTO();
				cate.setCategoryName(request.getParameter("cetegoryneme"));
				cate.setDescription(request.getParameter("description"));
				System.out.println("catename??===="+request.getParameter("cate_name"));
				CategoryServiceImpl.getInstance().registCategory(cate);
			
			break;
		default:
			break;
			
		}
	}
}
