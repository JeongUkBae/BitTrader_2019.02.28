package command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import proxy.Proxy;
import proxy.RequestProxy;
import proxy.ResponseProxy;
import java.util.HashMap;
import java.util.Map;*/

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("===== 6.캐리어 진입 =====");
		System.out.println("도착할 페이지는 ::"+Receiver.cmd.getView());
		/*
		 * RequestProxy req = (RequestProxy) pxy.get("req"); HttpServletRequest request
		 * = req.getRequest(); ResponseProxy resp = (ResponseProxy) pxy.get("resp");
		 * HttpServletResponse response = resp.getResponse();
		 * 
		 * req.carryOut(request); resp.carryOut(response);
		 */
		
		request.getRequestDispatcher(Receiver.cmd.getView())
		.forward(request,response);
	}
}
