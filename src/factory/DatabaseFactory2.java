package factory;

import pool.Constant;

public class DatabaseFactory2 {
	public static Database2 createDatabase(String vendor) {
		Database2 database = null;
		switch(vendor) {
		case "oracle": 
				database = new Oracle2(
						Constant.ORACLE_DRIVER,
						Constant.ORACLE_URL,
						Constant.USERNAME,
						Constant.PASSWORD);
			break;
		}
		
		return database;
	}
}
