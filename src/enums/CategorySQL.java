package enums;

public enum CategorySQL {
	CATE_LIST, CATE_REGISTER;
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case CATE_LIST: 
			query.append("SELECT * FROM CATEGORIES");
			
			break;
		case CATE_REGISTER:
			query.append("INSERT INTO CATEGORIES VALUES(CATEGORY_ID.NEXTVAL,?,?)");
			break;
			
		}
		return query.toString();
	}
}
