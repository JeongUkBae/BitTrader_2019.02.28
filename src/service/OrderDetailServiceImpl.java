package service;

import java.util.List;

import domain.OrderDetailDTO;

public class OrderDetailServiceImpl implements OrderDetailService{
	private static OrderDetailServiceImpl instance = new OrderDetailServiceImpl();
	public OrderDetailServiceImpl() {}
	public static OrderDetailServiceImpl getInstance() {return instance;}


	@Override
	public void registCustomer(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> bringAllOrderDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> retrieveOrderDetails(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO retrieveOrderDetail(String searchWord) {
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
	public void modifyOrderDetail(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderDetail(OrderDetailDTO ordd) {
		// TODO Auto-generated method stub
		
	}

}
