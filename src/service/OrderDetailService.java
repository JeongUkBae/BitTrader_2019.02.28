package service;

import java.util.List;

import domain.OrderDetailDTO;

public interface OrderDetailService {
	public void registCustomer(OrderDetailDTO ordd);
	
	public List<OrderDetailDTO> bringAllOrderDetailsList();
	public List<OrderDetailDTO> retrieveOrderDetails(String searchWord);
	public OrderDetailDTO retrieveOrderDetail(String searchWord);
	public int countOrderDetail();
	public boolean existsOrderDetail(String searchWord);
	
	public void modifyOrderDetail(OrderDetailDTO ordd);
	public void removeOrderDetail(OrderDetailDTO ordd);
}
