package dao;

import java.util.List;

import domain.OrderDTO;

public class OrderDAOImpl implements OrderDAO {
	private static OrderDAOImpl instance = new OrderDAOImpl();
	private OrderDAOImpl() {
		dao=OrderDAOImpl.getInstance();}
	public static OrderDAOImpl getInstance() {return instance;}
	OrderDAO dao;


	@Override
	public void insertCustomer(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDTO> selectAllOrdersList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> selectOrders(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO selectOrder(String searchWord) {
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
	public void updateOrder(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(OrderDTO ordd) {
		// TODO Auto-generated method stub
		
	}

}
