package service;

import java.util.List;

import domain.OrderDTO;

public class OrderServiceImpl implements OrderService {
	private static OrderServiceImpl instance = new OrderServiceImpl();
	private OrderServiceImpl() {}
	public static OrderServiceImpl getInstance() {return instance;}
	

	@Override
	public void registCustomer(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDTO> bringAllOrdersList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> retrieveOrders(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO retrieveOrder(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsOrder(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyOrder(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

}
