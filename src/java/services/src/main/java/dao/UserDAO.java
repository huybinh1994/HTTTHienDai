package dao;

import model.UserDTO;

public interface UserDAO {
	public UserDTO loGin(String user, String pass);
}
