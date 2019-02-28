package enums;

/*
 * employeeID, 
	manager,
	name, 
	birthDate, 
	photo,
	notes;
	*/
public enum EmployeeSQL {
	REGISTER, ACCESS;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES("
					+ "EMPLOYEE_ID, MANAGER, NAME, BIRTH_DATE, PHOTO, NOTES) VALUES("
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, '102', ?)");
			break;
		case ACCESS:
			query.append("select *\n" + 
					"from employees\n" + 
					"where employee_id like ? and name like ?");
			
			break;
		default:
			break;
		}
		return query.toString();
	}
}
