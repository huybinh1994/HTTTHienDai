package service;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
		if(userDTO != null){
			String token = Sha256.convertSha256(Sha256.convertSha256(user));
			tokenDTO.setAuther_id(userDTO);
			DateTime dt = new DateTime(DateTimeZone.UTC);
			tokenDTO.setExpire(new Date(System.currentTimeMillis()));
			tokenDTO.setToken(token);
			if(tkDAO.insert(tokenDTO)){
				return  tokenDTO;
			}
		}
		//check ok
		return null;
	}
	
	

}
