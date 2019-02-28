package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import domain.ImageDTO;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaceFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	private ImageDAOImpl() {
		conn = DatabaceFactory
							.createDatabase(Vendor.ORACLE)
							.getConnection();
		
	}
	public static ImageDAOImpl getInstance() {return instance;}


	@Override
	public void insertImage(ImageDTO img) {
		
		try {
			System.out.println("[****] insertImage  ===입장. ");
			String sql = ImageSQL.IMAGE_UPLOAD.toString();
			PreparedStatement ps = DatabaceFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());

			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"입력성공":"입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ImageDTO> selectAllimageList(Proxy pxy) {
		List<ImageDTO> list = null;
		
		try {
			String sql = "";
			PreparedStatement ps =  DatabaceFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ImageDTO> SelectImages(Proxy pxy) {
		List<ImageDTO> list = null;
		
		try {
			String sql = "";
			PreparedStatement ps =  DatabaceFactory
									.createDatabase(Vendor.ORACLE)
									.getConnection()
									.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ImageDTO selectImage(ImageDTO img) {
		ImageDTO dto = null;
		
		try {
			dto = new ImageDTO();
			
			String sql = ImageSQL.IMAGE_SELECT.toString();
			PreparedStatement ps = DatabaceFactory
								   .createDatabase(Vendor.ORACLE)
								   .getConnection()
								   .prepareStatement(sql);
			System.out.println("imgseq::"+img.getImgSeq());
			ps.setString(1, img.getImgSeq());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setImgName(rs.getString("IMG_NAME"));
				dto.setImgExtention(rs.getString("IMG_EXTENTION"));
				dto.setOwner(rs.getString("OWNER"));
				dto.setImgSeq(rs.getString("IMG_SEQ"));
				System.out.println("dto11111???"+dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("dto22222???"+dto);
		return dto;
	}

	@Override
	public int countImages(ImageDTO img) {
		int count = 0;

		try {
			String sql = "";
			PreparedStatement ps = DatabaceFactory
								   .createDatabase(Vendor.ORACLE)
								   .getConnection()
								   .prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void updateImage(Proxy pxy) {
		
		try {
			String sql = "";
			PreparedStatement ps = DatabaceFactory
								   .createDatabase(Vendor.ORACLE)
								   .getConnection()
								   .prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"수정성공":"수정실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteImage(Proxy pxy) {

		try {
			String sql ="";
			PreparedStatement ps = DatabaceFactory
								   .createDatabase(Vendor.ORACLE)
								   .getConnection()
								   .prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"삭제성공":"삭제실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String lastImageSeq() {
		String ls = "";
		
		try {
			PreparedStatement ps = conn.prepareStatement(ImageSQL.LAST_IMAGESEQ.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls = rs.getString("IMG_SEQ");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("LastSeq ::"+ls);
		return ls;
	}

}
