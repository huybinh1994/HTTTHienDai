package dao;

import java.util.List;

import model.AgentSubAgent;
import model.MasterDTO;
import model.MerchantsDTO;;

public interface MerchantDAO {
	public List<MerchantsDTO> getAll();
	public Boolean insert(MerchantsDTO m);
	public Boolean findByMerchant(MerchantsDTO m);
	public Boolean deleteTK(MerchantsDTO m);
	public List<MerchantsDTO> getMerchantByMasterId(int master_id);
	public List<AgentSubAgent> getAngentSubAgent();
	public int getNextIdentity();
}
