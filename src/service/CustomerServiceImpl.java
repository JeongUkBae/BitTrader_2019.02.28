package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	CustomerDAO dao;	
	private CustomerServiceImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}

	@Override
	public void registCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
	}

	@Override
	public List<CustomerDTO> bringAllCustomersList(Proxy pxy) {
		
		return dao.selectAllCustomersList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(Proxy pxy) {
		// TODO Auto-generated method stub
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		System.out.println("retrieveCustomer=== 서비스 impl");
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomer(Proxy pxy) {
		
		return dao.countCustomer(pxy);
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		
		return dao.existsCustomerID(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		dao.deleteCustomer(cus);
		
	}
	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		
		return dao.selectPhone(pxy);
	}
	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		
		return dao.selectProfile(pxy);
		
		
	}

}
