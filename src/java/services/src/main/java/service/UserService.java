package service;

import model.TokensDTO;

public interface UserService {
	public TokensDTO login(String user, String pass);
}
