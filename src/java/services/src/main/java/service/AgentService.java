package service;

import model.MerchantsDTO;
import model.UserDTO;

public interface AgentService {
	public Boolean insert(MerchantsDTO m);
	public Boolean delete(MerchantsDTO m);
	public Boolean update(MerchantsDTO m);
	public MerchantsDTO insertAgentAndUser(MerchantsDTO m, UserDTO u);
}
