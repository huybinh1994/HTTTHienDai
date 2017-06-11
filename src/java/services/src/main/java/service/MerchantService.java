package service;

import java.util.List;

import dao.MerchantDAO;
import model.AgentSubAgent;
import model.MerchantsDTO;

public interface MerchantService {

	public List<MerchantsDTO> getAll();

	Boolean findMerchant(MerchantsDTO m);

	Boolean deleteTK(MerchantsDTO m);
	
	public List<MerchantsDTO> getMerchantByMasterId(int master_id);
	
	public List<AgentSubAgent> getAgentSubAgent();
	public int getNextIdentity();
	public List<MerchantsDTO> Find_Agent(int masterId);
	public List<MerchantsDTO> Find_subAgent(int masterId , int agentId);
	public List<MerchantsDTO> Find_Merchant(int masterId, int agentId,int subAgentId);
}
