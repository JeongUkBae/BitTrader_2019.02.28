package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(Map<String, Proxy> pxy) {
		super(pxy);
		System.out.println("-----ExistCommand-----");
		
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		HttpSession session =  request.getSession();
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER: case ACCESS:
			System.out.println("커맨더 REGISTER/ACCESS 들어옴===");
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("ename"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exist) {
				System.out.println("사원 접근허용 ::"+exist);
				Proxy paging = new Pagination();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				List<CustomerDTO> list =  CustomerServiceImpl
						.getInstance().bringAllCustomersList(pagePxy);
				
				 System.out.println("한페이지 고객의 수: "+list.size());
				 System.out.println("가장 최근에 가입한 고객명:"+list.get(0).getCustomerName());
				
				session.setAttribute("emp", emp);
				request.setAttribute("emp", emp);
				request.setAttribute("list", list);
				request.setAttribute("pagination", paging);
			}else {
				System.out.println("접근불허");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			System.out.println("ExistCommand 내부::"+Receiver.cmd.view);
			break;
		
		
		case SIGNIN:
			System.out.println("CASE = SIGNIN 입장!");
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(request.getParameter("customerid"));
			cus.setPassword(request.getParameter("cpassword"));
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			if(cus != null) {
				System.out.println("로그인허용");
				session.setAttribute("cus", cus);
				request.setAttribute("cus", cus);
			}else {
				System.out.println("로그인불가!!!!");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			System.out.println("ExistComand 내부 (SIGNIN):::"+super.getView());
			break;
		default:
			break;
		
		}
		
				
	}
	
}
