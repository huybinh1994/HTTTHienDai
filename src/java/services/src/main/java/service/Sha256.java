package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Sha256 {
	public static String convertSha256 (String input)
	{
		Timestamp time = new Timestamp(System.currentTimeMillis());
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
	        byte[] result = mDigest.digest((input+"-"+time).getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}		
	}
}
