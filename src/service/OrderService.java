package service;

import java.util.List;

import domain.OrderDTO;

public interface OrderService {
	public void registCustomer(OrderDTO ordd);
	
	public List<OrderDTO> bringAllOrdersList();
	public List<OrderDTO> retrieveOrders(String searchWord);
	public OrderDTO retrieveOrder(String searchWord);
	public int countOrder();
	public boolean existsOrder(String searchWord);
	
	public void modifyOrder(OrderDTO ordd);
	public void removeOrder(OrderDTO ordd);
}
