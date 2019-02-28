package dao;

import java.util.List;

import domain.OrderDetailDTO;

public class OrderDetailDAOImpl implements OrderDetailDAO {
	private static OrderDetailDAOImpl instance = new OrderDetailDAOImpl();
	private OrderDetailDAOImpl() {
		dao = OrderDetailDAOImpl.getInstance();}
	public static OrderDetailDAOImpl getInstance() {return instance;}
	OrderDetailDAO dao;

	@Override
	public void insertCustomer(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> selectAllOrderDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> selectOrderDetails(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO selectOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateOrderDetail(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetail(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

}
