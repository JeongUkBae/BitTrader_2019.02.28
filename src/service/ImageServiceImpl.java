package service;

import java.util.List;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService{
	private static ImageServiceImpl instance = new ImageServiceImpl();
	ImageDAO dao;
	public ImageServiceImpl() {dao=ImageDAOImpl.getInstance();}
	public static ImageServiceImpl getInstance() {return instance;}


	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
		
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		
		return dao.selectAllimageList(pxy);
	}

	@Override
	public List<ImageDTO> searchImages(Proxy pxy) {
		
		return dao.SelectImages(pxy);
	}

	@Override
	public ImageDTO searchImage(ImageDTO img) {
		
		return dao.selectImage(img);
	}
	@Override
	public int imageCount(ImageDTO img) {
		
		return dao.countImages(img);
	}

	@Override
	public void modifyImage(Proxy pxy) {
		dao.updateImage(pxy);
		
	}

	@Override
	public void removeImage(Proxy pxy) {
		dao.deleteImage(pxy);
		
	}


}
