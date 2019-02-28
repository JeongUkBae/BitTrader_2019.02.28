package command;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ImageServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(Map<String, Proxy> pxy) {
			super(pxy);
			System.out.println("RetrieveCommand 진입 ====");
		
			RequestProxy req = (RequestProxy) pxy.get("req");
			HttpServletRequest request = req.getRequest();
		//	HttpSession session =  request.getSession();
			
			System.out.println("case : CUST_RETRIEVE 진입 ");
			System.out.println("cust??"+request.getParameter("customer_id"));
			
			CustomerDTO cust = new CustomerDTO();
			ImageDTO image= new ImageDTO();
			cust.setCustomerID(request.getParameter("customer_id"));
			cust = CustomerServiceImpl.getInstance().retrieveCustomer(cust);
			System.out.println("getPhoto??"+cust.getPhoto());
			image.setImgSeq(cust.getPhoto());
			image = ImageServiceImpl.getInstance().searchImage(image);
			
			System.out.println("cust??"+cust);
			System.out.println("image??"+image);
			
			request.setAttribute("cust", cust);
			request.setAttribute("image", image);
		//	session.setAttribute("cust", cust);
		
	}
}
