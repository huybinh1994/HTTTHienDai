package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AgentDAO;
import model.MerchantsDTO;
import model.UserDTO;

public class AgentServiceImpl implements AgentService {
	private AgentDAO ad;
	
	public AgentDAO getAgentDAO() {
		return ad;
	}
	@Autowired
	public void setAgentDAO(AgentDAO ad) {
		this.ad = ad;
	}
	
	@Override
	public Boolean insert(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return ad.insert(m);
	}

	@Override
	public Boolean delete(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return ad.delete(m);
	}

	@Override
	public Boolean update(MerchantsDTO m) {
		// TODO Auto-generated method stub
		return ad.update(m);
	}

	@Override
	public MerchantsDTO insertAgentAndUser(MerchantsDTO m, UserDTO u) {
		// TODO Auto-generated method stub
		return ad.insertAgentAndUser(m, u);
	}

}
