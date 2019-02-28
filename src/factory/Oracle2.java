package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import pool.Constant;

public class Oracle2 implements Database2{
	private Connection conn;
	private String driver, url, username, password;
	
	public Oracle2(String driver, String url,
			String username, String password) {
		
		this.driver =  driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public Connection getConnection() {
		conn = null;
		try {
			Class.forName(Constant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(
					Constant.ORACLE_URL, Constant.USERNAME, Constant.PASSWORD);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}
