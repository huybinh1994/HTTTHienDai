package dao;

import java.util.List;

import model.AgentSubAgent;
import model.MasterDTO;
import model.MerchantsDTO;
import model.UserDTO;

public interface MerchantDAO {
	public List<MerchantsDTO> getAll();
	public Boolean insert(MerchantsDTO m);
	public Boolean findByMerchant(MerchantsDTO m);
	public Boolean deleteTK(MerchantsDTO m);
	public List<MerchantsDTO> getMerchantByMasterId(int master_id);
	public List<AgentSubAgent> getAngentSubAgent();
	public int getNextIdentity();
	public MerchantsDTO insertMerchantAndUser(MerchantsDTO m, UserDTO u);
	public List<MerchantsDTO> Find_Agent(int masterId);
	public List<MerchantsDTO> Find_subAgent(int masterId , int agentId);
	public List<MerchantsDTO> Find_Merchant(int masterId, int agentId,int subAgentId);
}
