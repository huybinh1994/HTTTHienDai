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

}
