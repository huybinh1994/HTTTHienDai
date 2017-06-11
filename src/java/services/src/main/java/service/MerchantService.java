package service;

import java.util.List;

import dao.MerchantDAO;
import model.AgentSubAgent;
import model.MerchantsDTO;
import model.UserDTO;

public interface MerchantService {

	public List<MerchantsDTO> getAll();

	Boolean findMerchant(MerchantsDTO m);

	Boolean deleteTK(MerchantsDTO m);
	
	public List<MerchantsDTO> getMerchantByMasterId(int master_id);
	
	public List<AgentSubAgent> getAgentSubAgent();
	public int getNextIdentity();
	public MerchantsDTO insertMerchantAndUser(MerchantsDTO m, UserDTO u);
}
