package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MerchantDAO;
import model.AgentSubAgent;
import model.MerchantsDTO;
import model.UserDTO;
@Service
public class MerchantServiceImpl implements MerchantService{

	private MerchantDAO md;
	
	public MerchantDAO getTkd() {
		return md;
	}
	@Autowired
	public void setMerchant(MerchantDAO md) {
		this.md = md;
	}

	@Override
	public Boolean findMerchant(MerchantsDTO m) {
		
		return md.findByMerchant(m);
	}
	@Override
	public Boolean deleteTK(MerchantsDTO m) {
		
		return md.deleteTK(m);
	}
	@Override
	public List<MerchantsDTO> getAll() {
		// TODO Auto-generated method stub
		return md.getAll();
	}
	@Override
	public List<MerchantsDTO> getMerchantByMasterId(int master_id) {
		// TODO Auto-generated method stub
		return md.getMerchantByMasterId(master_id);
	}
	@Override
	public List<AgentSubAgent> getAgentSubAgent() {
		// TODO Auto-generated method stub
		return md.getAngentSubAgent();
	}
	@Override
	public int getNextIdentity() {
		// TODO Auto-generated method stub
		return md.getNextIdentity();
	}
	@Override
	public MerchantsDTO insertMerchantAndUser(MerchantsDTO m, UserDTO u) {
		// TODO Auto-generated method stub
		return md.insertMerchantAndUser(m, u);
	}
	public List<MerchantsDTO> Find_Agent(int masterId) {
		// TODO Auto-generated method stub
		return md.Find_Agent(masterId);
	}
	@Override
	public List<MerchantsDTO> Find_subAgent(int masterId, int agentId) {
		// TODO Auto-generated method stub
		return md.Find_subAgent(masterId, agentId);
	}
	@Override
	public List<MerchantsDTO> Find_Merchant(int masterId, int agentId, int subAgentId) {
		// TODO Auto-generated method stub
		return md.Find_Merchant(masterId, agentId, subAgentId);
	}
	@Override
	public List<MerchantsDTO> getbyid(int i) {
		// TODO Auto-generated method stub
		return md.getbyid(i);
	}
}
