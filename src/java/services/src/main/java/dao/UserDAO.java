package dao;

import model.MerchantsDTO;
import model.UserDTO;

public interface UserDAO {
	public UserDTO loGin(String user, String pass);
	public Boolean insert(UserDTO user);
	
	public Integer insertGetId(UserDTO user);
}
