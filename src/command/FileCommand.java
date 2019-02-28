package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ImageServiceImpl;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();

		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			System.out.println("[ ***파일 커맨드 업로드 진입*** ]");
			ImageProxy ipxy = new ImageProxy();
			ipxy.carryOut(request);
			// DB save
			ImageDTO image = ipxy.getImg();
			System.out.println("image??:::" + image);
			String customerID = ipxy.getImg().getOwner();
			//1.파일업로드한 이미지를 insert 해야함.
			//2.커스터머안에 photo 에 대표 이미지를 방금 인서트한 
			//  이미지로 바꿔야 한다. 단 default_photo.jpg 로 
			//  되어 있는 것을 이미지의 seq 값으로 바꾼다.
			//3.이후 고객의 정보
			//4.이미지에서 seq 에 따른 이미지 정보 
			//  두개를 가져온다.  
			//ImageServiceImpl.getInstance().addImage(image);  
			//DB입력!
			//CustomerServiceImpl.getInstance().fileUpload(ipxy);
			Map<String, Object> map = new HashMap<>();
			map = CustomerServiceImpl.getInstance().fileUpload(ipxy);
			System.out.println("map image??::"+map.get("image"));
			System.out.println("map image??::"+map.get("cust"));
			
			//ipxy.getImg().setOwner(request.getParameter("customer_id")); 
			 // CustomerDTO cust = CustomerServiceImpl.getInstance().fileUpload(ipxy);
			  
			request.setAttribute("image", map.get("image")); 
			request.setAttribute("cust", map.get("cust"));
			 
			break;

		default:
			break;

		}

	}
}
