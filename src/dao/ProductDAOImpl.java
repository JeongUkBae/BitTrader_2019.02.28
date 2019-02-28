package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import enums.Vendor;
import factory.DatabaceFactory;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO{
	private static ProductDAOImpl instance = new ProductDAOImpl();
	Connection conn ;
	private ProductDAOImpl() {
		conn = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	public static ProductDAOImpl getInstance() {return instance;}


	@Override
	public void insertproduct(ProductDTO pro) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductDTO> selectProductsList(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		
		try {
			
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProductDTO> selectProducts(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProduct(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsProductID(ProductDTO pro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateProduct(ProductDTO pro) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(ProductDTO pro) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

}
