package enums;

/*customerID, customerName, password, address,
city, postalcode, ssn;*/
public enum CustomerSQL {
	SIGNUP, SIGNIN, LIST, ROW_COUNT, PHONE, ONE_RETRIEVE, CUST_UPDATE, REMOVE;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case SIGNUP: 
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, "
					+ "PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE)"
			       + "VALUES(?,?,?,?,?,'103',?,?,?)");
			
			break;
		case SIGNIN: 
			query.append("SELECT * \n" + 
					"FROM CUSTOMERS \n" + 
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ? ");
			break;
		case LIST: 
			query.append("SELECT T2.* FROM"
						+ "(SELECT ROWNUM R2, T.* FROM "
						+ "(SELECT ROWNUM RNUM, C.* FROM\n" + 
					" CUSTOMERS C ORDER BY RNUM DESC) T ) T2 WHERE R2 BETWEEN ? AND ?");
			
			/* rownum 하나 더 만들어서 1부터 시작하게 만듬 .
			 * SELECT T2.* FROM(SELECT ROWNUM R2, T.* FROM (SELECT ROWNUM RNUM, C.* FROM
			 * CUSTOMERS C ORDER BY RNUM DESC) T ) T2 WHERE R2 BETWEEN 1 AND 5;
			 */
			/*
			 * "SELECT T.* \n" + "        FROM (SELECT ROWNUM RNUM, C.* \n" +
			 * "        FROM CUSTOMERS C \n" + "        ORDER BY RNUM DESC) T \n" +
			 * "WHERE RNUM BETWEEN ? AND ?"
			 */
			
			break;
		case ROW_COUNT:
			query.append("select count(*) AS COUNT from customers");
			break;
			
		case PHONE:
			query.append("SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE \n" + 
					"FROM CUSTOMERS");
			break;
		case ONE_RETRIEVE:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
		case CUST_UPDATE:
			query.append("UPDATE  \n" + 
					"(SELECT * \n" + 
					"FROM CUSTOMERS\n" + 
					"WHERE CUSTOMER_ID LIKE ?)\n" + 
					"SET PASSWORD = ?, PHONE = ?, \n" + 
					"CITY = ?, \n" + 
					"ADDRESS = ?, POSTAL_CODE = ?, PHOTO = ?");
			break;
		case REMOVE:
			query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
}
