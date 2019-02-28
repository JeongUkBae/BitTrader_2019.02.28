package service;

import java.util.List;
import java.util.Map;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService {
	private static ProductServiceImpl instance = new ProductServiceImpl();
	ProductDAO dao;
	private ProductServiceImpl() {dao = ProductDAOImpl.getInstance();}
	public static ProductServiceImpl getInstance() {return instance;}


	@Override
	public void registCustomer(ProductDTO pro) {
		dao.insertproduct(pro);
		
	}

	@Override
	public List<ProductDTO> bringProductList(Proxy pxy) {
		
		return dao.selectProductsList(pxy);
	}

	@Override
	public List<ProductDTO> retrieveProducts(Proxy pxy) {
		
		return dao.selectProducts(pxy);
	}

	@Override
	public ProductDTO retrieveProduct(ProductDTO pro) {
		
		return dao.selectProduct(pro);
	}

	@Override
	public int countProductr(Proxy pxy) {
	
		return dao.countProduct(pxy);
	}

	@Override
	public boolean existsProductID(ProductDTO pro) {
		// TODO Auto-generated method stub
		return dao.existsProductID(pro);
	}

	@Override
	public void modifyProduct(ProductDTO pro) {
		dao.updateProduct(pro);
		
	}

	@Override
	public void removeProduct(ProductDTO pro) {
		dao.deleteProduct(pro);
		
	}

	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

}
