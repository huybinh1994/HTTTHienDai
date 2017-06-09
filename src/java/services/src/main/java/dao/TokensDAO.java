package dao;

import model.TokensDTO;

public interface TokensDAO {
	public Boolean insert(TokensDTO tk);
	public Boolean findByTK(TokensDTO tk);
	public Boolean deleteTK(TokensDTO tk);
}
