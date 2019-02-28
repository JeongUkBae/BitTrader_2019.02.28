package dao;

import java.util.List;

import domain.OrderDTO;

public interface OrderDAO {
	public void insertCustomer(OrderDTO ordd);
	
	public List<OrderDTO> selectAllOrdersList();
	public List<OrderDTO> selectOrders(String searchWord);
	public OrderDTO selectOrder(String searchWord);
	public int countOrder();
	public boolean existsOrder(String searchWord);
	
	public void updateOrder(OrderDTO ordd);
	public void deleteOrder(OrderDTO ordd);
}
