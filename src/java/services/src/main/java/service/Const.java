package service;

import java.text.SimpleDateFormat;
import java.sql.*;
public class Const {
	public  static String getCreatedDateTime(Date date) {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	    String datecv = simpleDateFormat.format(new java.util.Date());
	    
		return "";
	}
}
