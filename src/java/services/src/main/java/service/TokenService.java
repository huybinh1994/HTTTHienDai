package service;

import model.TokensDTO;

public interface TokenService {
	public Boolean finTokenByTK(TokensDTO tk);
	public Boolean deleteTK(TokensDTO tk);
}
