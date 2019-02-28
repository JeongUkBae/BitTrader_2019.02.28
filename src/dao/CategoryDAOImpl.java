package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaceFactory;
import proxy.Proxy;


public class CategoryDAOImpl implements CategoryDAO{
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	Connection conn;
	private CategoryDAOImpl() {
		conn = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static CategoryDAOImpl getInstance() {return instance;}
	


	@Override
	public void insertCategory(CategoryDTO cate) {
		
		try {
			String sql = CategorySQL.CATE_REGISTER.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCategoryName());
			ps.setString(2, cate.getDescription());
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"입력성공":"입력실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CategoryDTO> selectAllCategoriesList(Proxy Pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		CategoryDTO cat = null;
		try {
			String sql = CategorySQL.CATE_LIST.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) {
				cat = new CategoryDTO();
				cat.setCategoryID(rs.getString("CATEGORY_ID"));
				cat.setCategoryName(rs.getString("CATEGORY_NAME"));
				cat.setDescription(rs.getString("DESCRIPTION"));
				list.add(cat);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("catList?:: "+list);
		return list;
	}

	@Override
	public List<CategoryDTO> selectCategories(Proxy Pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectCategory(Proxy Pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCategory(Proxy Pxy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}

}
