package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageService {
	public void addImage(ImageDTO img);
	public List<ImageDTO> imageList(Proxy pxy);
	public List<ImageDTO> searchImages(Proxy pxy);
	public ImageDTO searchImage(ImageDTO img);
	public int imageCount(ImageDTO img);
	
	public void modifyImage(Proxy pxy);
	public void removeImage(Proxy pxy);

}
