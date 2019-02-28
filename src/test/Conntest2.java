package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import enums.Props;
import enums.Vendor;
/*employeeID, 
manager,
name, 
birthDate, 
photo,
notes;*/
public class Conntest2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		
		try {
			Class.forName(Props.ORA_DRIVER.getValue());
		
			String sql = "SELECT COUNT(*) AS COUNT FROM EMPLOYEES";
					
			conn=DriverManager.getConnection(
					Props.DB_URL.getValue(),
					Props.DB_USER.getValue(),
					Props.DB_PASSWORD.getValue());
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			String count="";
			
			while(rs.next()) {
				count = rs.getString("COUNT");
			}
			System.out.println("회원의 수  :::"+count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		 * try { //DB에서 일나는 일들 Class.forName(Props.ORA_DRIVER.getValue()); conn =
		 * DriverManager.getConnection(Props.DB_URL.getValue(),
		 * Props.DB_USER.getValue(), Props.DB_PASSWORD.getValue()); stmt =
		 * conn.createStatement(); rs =
		 * stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM EMPLOYEES"); String count =
		 * ""; while(rs.next()) { count = rs.getString("COUNT"); }
		 * System.out.println("회원의 수  :::"+count); } catch (Exception e) {
		 * e.printStackTrace(); }finally { try { conn.close(); } catch (Exception e) {
		 * // TODO: handle exception e.printStackTrace(); } }
		 */
		
	}

	private static PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
