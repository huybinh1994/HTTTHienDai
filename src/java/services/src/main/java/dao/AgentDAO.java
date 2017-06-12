package dao;

import java.util.List;

import model.MasterDTO;
import model.MerchantsDTO;
import model.UserDTO;

public interface AgentDAO {
	public Boolean insert(MerchantsDTO m);
	public Boolean delete(MerchantsDTO m);
	public Boolean update(MerchantsDTO m);
	public MerchantsDTO insertAgentAndUser(MerchantsDTO m, UserDTO u);	
}
