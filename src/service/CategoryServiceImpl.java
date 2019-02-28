package service;

import java.util.List;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.PageProxy;
import proxy.Proxy;

public class CategoryServiceImpl implements CategoryService{
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	CategoryDAO dao;
	private CategoryServiceImpl() {dao=CategoryDAOImpl.getInstance();}
	public static CategoryServiceImpl getInstance() {return instance;}
	

	@Override
	public void registCategory(CategoryDTO cat) {
		dao.insertCategory(cat);
		
	}

	@Override
	public List<CategoryDTO> bringAllCategoriesList(Proxy Pxy) {
		// TODO Auto-generated method stub
		return dao.selectAllCategoriesList(Pxy);
	}

	@Override
	public List<CategoryDTO> retrieveCategories(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO retrieveCategory(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCategory(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}


}
