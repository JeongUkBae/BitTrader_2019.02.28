package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customerID = request.getParameter("customerID");
		System.out.println("???:::"+customerID);

		CustomerDTO cust = new CustomerDTO();
		cust.setCustomerID(request.getParameter("customerID"));
		cust = CustomerServiceImpl.getInstance().retrieveCustomer(cust);
		System.out.println("수정하기전 회원의 정보 : "+cust.toString());

		if(!request.getParameter("phone").equals(""))
			cust.setPhone(request.getParameter("phone"));
		if(!request.getParameter("password").equals(""))
			cust.setPassword(request.getParameter("password"));
		if(!request.getParameter("postal_code").equals(""))
			cust.setPostalcode(request.getParameter("postal_code"));
		if(!request.getParameter("city").equals(""))
			cust.setCity(request.getParameter("city"));
		if(!request.getParameter("address").equals(""))
			cust.setAddress(request.getParameter("address"));


		System.out.println("수정하려는 회원의 정보 : "+cust.toString());
		CustomerServiceImpl.getInstance().modifyCustomer(cust);
		request.setAttribute("cust", cust);
	}
}
