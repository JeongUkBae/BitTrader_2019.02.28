package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;


public class DeleteCommand extends Command{
	public DeleteCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customerID = request.getParameter("customer_id");
		System.out.println("id?"+customerID);
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_REMOVE :
				CustomerDTO cust = new CustomerDTO();
				cust.setCustomerID(request.getParameter("customer_id"));
				CustomerServiceImpl.getInstance().removeCustomer(cust);

			break;
		default:
			break;
			
		}
	}
}
