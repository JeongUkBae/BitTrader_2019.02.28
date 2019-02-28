package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.ProductDAOImpl;
import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;


public class ListCommand extends Command{
// sysout 
	// 가장 최근에 입력된 5명의 목록
		public ListCommand(Map<String, Proxy> pxy) {
			super(pxy);
			RequestProxy req = (RequestProxy) pxy.get("req");
			HttpServletRequest request = req.getRequest();
			
			//sysout cmd=list&page=list&page_num=2&page_size=5
			System.out.println("ListCommand =====입장 ====");
			System.out.println("cmd:::"+request.getParameter("cmd"));
			System.out.println("page:::"+request.getParameter("page"));
			System.out.println("page_num:::"+request.getParameter("page_num"));
			System.out.println("page_size:::"+request.getParameter("page_size"));
			System.out.println("페이지는?::"+super.getView());
			Proxy page = new Pagination();
			Proxy pagePxy = new PageProxy();
			page.carryOut(request);
			pagePxy.carryOut(page);
			List<?> list = new ArrayList<>();
			switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case CUST_LIST:
				
				 list = CustomerServiceImpl
						.getInstance().bringAllCustomersList(
												pagePxy);
				
				break;
			case CATE_LIST:
				list = CategoryServiceImpl.getInstance().bringAllCategoriesList(pagePxy);
				System.out.println("catList222::: "+ list);
				break;
			case PRO_LIST:
			
				list = ProductServiceImpl.getInstance().bringProductList(null);
				
				
				break;

			default:
				break;
			
			}
			request.setAttribute("list", list);
			request.setAttribute("pagination", page);
		}
}
