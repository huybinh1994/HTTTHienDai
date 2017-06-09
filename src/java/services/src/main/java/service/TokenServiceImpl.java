package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TokensDAO;
import model.TokensDTO;
@Service
public class TokenServiceImpl implements TokenService{

	private TokensDAO tkd;
	
	public TokensDAO getTkd() {
		return tkd;
	}
	@Autowired
	public void setTkd(TokensDAO tkd) {
		this.tkd = tkd;
	}

	@Override
	public Boolean finTokenByTK(TokensDTO tk) {
		
		return tkd.findByTK(tk);
	}
	@Override
	public Boolean deleteTK(TokensDTO tk) {
		
		return tkd.deleteTK(tk);
	}

}
