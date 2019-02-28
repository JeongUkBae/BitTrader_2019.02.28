package enums;

public enum ImageSQL {
	IMAGE_UPLOAD, LAST_IMAGESEQ, IMAGE_SELECT;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case IMAGE_UPLOAD: 
			query.append("INSERT INTO IMAGES(img_seq, img_name, img_Extention, owner)\r\n" + 
					"VALUES(img_seq.NEXTVAL, ?, ?, ?)");
			
			break;
		case LAST_IMAGESEQ:
			query.append("select MAX(img_seq) img_seq\n" + 
					"from images");	
			/*
			 * "select img_seq\n" + "from (select rownum, img_seq\n" + "    from images\n" +
			 * "    where rownum = 1\n" + "    order by IMG_SEQ desc)"
			 */
			break;
		case IMAGE_SELECT: 
			query.append("select * from images where img_seq like ?");
			
			break;
		default:
			break;
		}
		
		
		return query.toString();
	}
	
}
