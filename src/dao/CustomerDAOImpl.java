package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaceFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import service.ImageServiceImpl;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	private CustomerDAOImpl() {
		conn = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	public static CustomerDAOImpl getInstance() {return instance;}


	/*
	 * customerID, customerName, password, address, city, postalcode, ssn;
	 */
	@Override
	public void insertCustomer(CustomerDTO cus) {
		System.out.println("===CustomerDAO Impl 입장 ====");
		try {
			String sql = String.format(CustomerSQL.SIGNUP.toString());
			System.out.println("slq::::" + sql);
			Connection conn = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomerName());
			ps.setString(3, cus.getPassword());
			ps.setString(4, cus.getSsn());
			ps.setString(5, cus.getPhone());
			
			ps.setString(6, cus.getCity());
			ps.setString(7, cus.getAddress());
			ps.setString(8, cus.getPostalcode());

			int rs = ps.executeUpdate();
			System.out.println((rs == 1) ? "입력성공" : "입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<CustomerDTO> selectAllCustomersList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement stmt = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.LIST.toString());
			System.out.println("DAOImpl SelectAll CustomersList ====!!!");
			System.out.println("실행할 쿼리\n"+CustomerSQL.LIST.toString());
			
			  System.out.println("startRow::"+ page.getStartRow());
			  System.out.println("EndRow::"+ page.getEndRow());
			String startRow =String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			stmt.setString(1, startRow);
			stmt.setString(2, endRow);

			ResultSet rs = stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				cust = new CustomerDTO();
				cust.setCount(rs.getString("RNUM"));
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setSsn(rs.getString("SSN"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPhoto(rs.getString("PHOTO"));
				cust.setCity(rs.getString("CITY"));
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setPostalcode(rs.getString("POSTAL_CODE"));
				list.add(cust);
			}
			/*
			 * System.out.println("1번회원:"+list.get(0).getCustomerName());
			 * System.out.println("1번 주소:"+list.get(0).getPostalcode());
			 * System.out.println("2번회원:"+list.get(1).getCustomerName());
			 * System.out.println("3번회원:"+list.get(2).getCustomerName());
			 * System.out.println("4번회원:"+list.get(3).getCustomerName());
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<CustomerDTO>();
		System.out.println("DAO 임플 입장 ");
		try {
			String sql = "";
			PreparedStatement stmt = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			stmt.setString(1, "");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(null);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cust) {
		CustomerDTO dto = null;
		System.out.println("DAO 임플 입장 ");
		System.out.println("id???"+cust.getCustomerID());
		
		try {
			String sql  = "";
			if(cust.getPassword()==null) {
				System.out.println("CustomerSQL.ONE_RETRIEVE.toString()");
				sql = CustomerSQL.ONE_RETRIEVE.toString();
				
			}else {
				sql = CustomerSQL.SIGNIN.toString();
				
			}
			PreparedStatement stmt = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			
			if(cust.getPassword()==null) {
				stmt.setString(1, cust.getCustomerID());
			} else {
				stmt.setString(1, cust.getCustomerID());
				stmt.setString(2, cust.getPassword());
			}
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dto = new CustomerDTO();
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setCity(rs.getString("CITY"));
				dto.setCustomerID(rs.getString("CUSTOMER_ID"));
				dto.setCustomerName(rs.getString("CUSTOMER_NAME"));
				dto.setPhone(rs.getString("phone"));
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setPostalcode(rs.getString("POSTAL_CODE"));
				dto.setSsn(rs.getString("SSN"));
				dto.setPhoto(rs.getString("PHOTO"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int count = 0;

		try {

			PreparedStatement stmt = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.ROW_COUNT.toString());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("COUNT");
			}
			System.out.println("count??::" + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		boolean ok = false;
		try {

			PreparedStatement ps = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());
			System.out.println("sql??:::" + CustomerSQL.SIGNIN.toString());
			System.out.println("id:" + cus.getCustomerID());
			System.out.println("ps:" + cus.getPassword());

			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			System.out.println("rs:::" + rs);
			if (rs.next()) {
				ok = true;
			}
			System.out.println("==existsCustomerDAO!!!!===");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ok??::" + ok);
		return ok;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {

		try {
			
			//String imgSeq = 
			String sql = CustomerSQL.CUST_UPDATE.toString();
			PreparedStatement ps = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ps.setString(3, cus.getPhone());
			ps.setString(4, cus.getCity());
			ps.setString(5, cus.getAddress());
			ps.setString(6, cus.getPostalcode());
			
			/*("UPDATE  \n" + 
					"(SELECT * \n" + 
					"FROM CUSTOMERS\n" + 
					"WHERE CUSTOMER_ID LIKE ?)\n" + 
					"SET PASSWORD = ?, PHONE = ?, \n" + 
					"CITY = ?, \n" + 
					"ADDRESS = ?, POSTAL_CODE = ?");*/
			
			int rs = ps.executeUpdate();
			System.out.println((rs == 1) ? "수정성공" : "수정실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {

		try {
			String sql = CustomerSQL.REMOVE.toString();
			PreparedStatement stmt = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			stmt.setString(1, cus.getCustomerID());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			PreparedStatement ps = DatabaceFactory.createDatabase(Vendor.ORACLE)
									.getConnection().prepareStatement(CustomerSQL.PHONE.toString());
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;
			
			while(rs.next()) {
				cust = new CustomerDTO();
				String entry = rs.getString("CUSTOMER_ID");
				cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setPhone(rs.getString("PHONE"));
				map.put(entry, cust);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		Map<String, Object> map = new HashMap<>();
		CustomerDTO cust = new CustomerDTO();
		ImageDTO image = new ImageDTO();
		try {
			System.out.println("CustomerDAOImpl selectProfile====입장!!");
			String sql = "";
			ImageProxy ipxy = (ImageProxy)pxy;
			ImageDAOImpl.getInstance().insertImage(ipxy.getImg());
			
			String imgSeq = ImageDAOImpl.getInstance().lastImageSeq();
			System.out.println("imgSeq::"+imgSeq);
			sql = "UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ? ";
			PreparedStatement ps = DatabaceFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, imgSeq);
			System.out.println("imgSeq22::"+imgSeq);
			ps.setString(2, ipxy.getImg().getOwner());
			System.out.println("Owner??::"+ipxy.getImg().getOwner());
			int rs = ps.executeUpdate();
			System.out.println((rs == 1) ? "포토수정성공" : "포토수정실패");
			
			cust.setCustomerID(ipxy.getImg().getOwner()); 
			cust = selectCustomer(cust);
			System.out.println("cust?:::"+cust);
			
			
			image.setImgSeq(imgSeq);
			image = ImageServiceImpl.getInstance().searchImage(image);
			map.put("image",image);
			map.put("cust", cust);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
		
	}

}
