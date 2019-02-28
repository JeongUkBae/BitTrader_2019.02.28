package enums;

import java.io.File;

public enum Props {

	ORA_DRIVER("oracle.jdbc.OracleDriver"),
	DB_URL("jdbc:oracle:thin:@localhost:1521:xe"), 
	DB_USER("oracle"),
	DB_PASSWORD("password"),
	IMAGE("C:"+File.separator+"Users"
				+File.separator+"hanbit"
				+File.separator+"workspace"
				+File.separator+"jee-workspace"
				+File.separator+"BitTrader"
				+File.separator+"WebContent"
				+File.separator+"resources"
				+File.separator+"img"
				+File.separator);
	
	private String value;
	
	private Props(String value) {
		  this.value = value;
	}

	public String getValue() {
		return value;
	}

}
