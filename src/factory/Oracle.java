package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import enums.Props;
import lombok.Data;

@Data
public class Oracle implements Database{
	private Connection conn;
	private String driver, url, user, password;
	
	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
			//"oracle.jdbc.OracleDriver"
			Class.forName(Props.ORA_DRIVER.getValue());
			conn = DriverManager.getConnection(Props.DB_URL.getValue(), 
					Props.DB_USER.getValue(), Props.DB_PASSWORD.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
