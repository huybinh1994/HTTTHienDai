package service;

import dao.UserDAO;
import model.TokensDTO;
import model.UserDTO;

public interface UserService {
	public TokensDTO login(String user, String pass);
	public Boolean insert(UserDTO user);
	public Integer insertGetId(UserDTO user);
	public Boolean isExistsEmail(String email);
	public int changePassword(int id, String oldPass, String newPass);
}
