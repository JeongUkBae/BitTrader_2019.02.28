package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageDAO {
	public void insertImage(ImageDTO img);
	public List<ImageDTO> selectAllimageList(Proxy pxy);
	public List<ImageDTO> SelectImages(Proxy pxy);
	public ImageDTO selectImage(ImageDTO img);
	public String lastImageSeq();
	public int countImages(ImageDTO img);
	
	public void updateImage(Proxy pxy);
	public void deleteImage(Proxy pxy);
}
