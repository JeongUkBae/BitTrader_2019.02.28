package dao;

import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {
	public void insertproduct(ProductDTO pro);
	
	public List<ProductDTO> selectProductsList(Proxy pxy);
	public List<ProductDTO> selectProducts(Proxy pxy);
	public ProductDTO selectProduct(ProductDTO pro);
	public int countProduct(Proxy pxy);
	public boolean existsProductID(ProductDTO pro);
	public void updateProduct(ProductDTO pro);
	public Map<String, Object> selectProfile(Proxy pxy);
	public void deleteProduct(ProductDTO pro);
	public Map<String, Object> selectPhone(Proxy pxy);
}
