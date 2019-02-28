package dao;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryDAO {
	public void insertCategory(CategoryDTO cate);
	
	public List<CategoryDTO> selectAllCategoriesList(Proxy Pxy);
	public List<CategoryDTO> selectCategories(Proxy Pxy);
	public CategoryDTO selectCategory(Proxy Pxy);
	public int countCategory();
	public boolean existsCategory(Proxy Pxy);
	
	public void updateCategory(CategoryDTO cate);
	public void deleteCategory(CategoryDTO cate);
}
