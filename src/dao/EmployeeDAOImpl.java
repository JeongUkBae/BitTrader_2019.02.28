package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmployeeDTO;
import enums.CustomerSQL;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaceFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeDAOImpl getInstance() {return instance;}
	EmployeeDAO dao;

	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		System.out.println("===Employee DAO Impl====");
		try {
			// EMPLOYEE_ID, MANAGER, NAME, BIRTH_DATE, PHOTO, NOTES
			String sql = String.format(EmployeeSQL.REGISTER.toString(),
				emp.getManager(),emp.getName(),emp.getBirthDate(),emp.getPhoto(),emp.getNotes());
			System.out.println("sql:::"+sql);
			Connection conn = DatabaceFactory
				.createDatabase(Vendor.ORACLE).getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			
			int rs = pstmt.executeUpdate();
		System.out.println((rs==1)?"입력성공":"입력실패");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<EmployeeDTO> selectAllEmployeeList() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			
			PreparedStatement ps =DatabaceFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.LIST.toString());
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
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			PreparedStatement ps = 
					DatabaceFactory.createDatabase(Vendor.ORACLE)
					.getConnection().prepareStatement(EmployeeSQL.ACCESS.toString());
			ps.setString(1, emp.getEmployeeID());
			ps.setString(2, emp.getName());
			if(ps.executeQuery().next()) {ok = true;}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("접근허용:"+ok);
		return ok;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
