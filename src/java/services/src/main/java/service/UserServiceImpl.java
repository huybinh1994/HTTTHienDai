package service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TokensDAO;
import dao.UserDAO;
import javassist.expr.Cast;
import model.TokensDTO;
import model.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	UserDAO usDao;
	TokensDAO tkDAO;
	

	public TokensDAO getTkDAO() {
		return tkDAO;
	}
	@Autowired
	public void setTkDAO(TokensDAO tkDAO) {
		this.tkDAO = tkDAO;
	}

	public UserDAO getUsDao() {
		return usDao;
	}

	@Autowired
	public void setUsDao(UserDAO usDao) {
		this.usDao = usDao;
	}


	@Override
	public TokensDTO login(String user, String pass) {
		// check login
		UserDTO userDTO = new UserDTO();
		TokensDTO tokenDTO = new TokensDTO();
		userDTO = usDao.loGin(user, pass);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		if(userDTO != null){
			String hash1 = Sha256.convertSha256(user+"-"+time);
			String token = Sha256.convertSha256(hash1);
			tokenDTO.setAuther_id(userDTO);
//			DateTime dt = new DateTime(DateTimeZone.UTC);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new java.util.Date();
//			System.out.println(dateFormat.format(date));
			try {
				date = dateFormat.parse(dateFormat.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tokenDTO.setExpire(date);
			tokenDTO.setToken(token);
			if(tkDAO.insert(tokenDTO)){
				tokenDTO.setToken(hash1);
				return  tokenDTO;
			}
		}
		//check ok
		return null;
	}
	
	

}
