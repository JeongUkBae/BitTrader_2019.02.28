package dao;

import java.util.List;

import domain.OrderDetailDTO;

public interface OrderDetailDAO {
	public void insertCustomer(OrderDetailDTO ordd);
	
	public List<OrderDetailDTO> selectAllOrderDetailsList();
	public List<OrderDetailDTO> selectOrderDetails(String searchWord);
	public OrderDetailDTO selectOrderDetail(String searchWord);
	public int countOrderDetail();
	public boolean existsOrderDetail(String searchWord);
	
	public void updateOrderDetail(OrderDetailDTO ordd);
	public void deleteOrderDetail(OrderDetailDTO ordd);
}
