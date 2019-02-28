package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.EmployeeDTO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		System.out.println("=====홈컨트롤 진입 ====");
		HttpSession session = request.getSession();
		session.setAttribute("ctx", request.getContextPath());
		session.setAttribute("css", session.getAttribute("ctx")+"/resources/css/");
		session.setAttribute("js", session.getAttribute("ctx")+"/resources/js/");
		session.setAttribute("img", session.getAttribute("ctx")+"/resources/img/");
		//확인 
		System.out.println("ctx:::"+request.getContextPath());
		System.out.println("css:::"+session.getAttribute("ctx")+"/resources/css/");
		System.out.println("js:::"+session.getAttribute("ctx")+"/resources/js/");
		System.out.println("img:::"+session.getAttribute("ctx")+"/resources/img/default-avatar.jpg");
		
		if(session.getAttribute("employee")==null) {
			request.setAttribute("compo", "register");
		} else {
			request.setAttribute("compo", "access");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home/main.jsp");
		rd.forward(request, response);
		/*
		 * String cmd = request.getParameter("cmd"); if(cmd==null) {cmd = "main";}
		 * System.out.println("cmd 는" + cmd);
		 */
		
	
		
	}

}
