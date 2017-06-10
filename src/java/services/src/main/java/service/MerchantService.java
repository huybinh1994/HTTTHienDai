package service;

import java.util.List;

import dao.MerchantDAO;
import model.MerchantsDTO;;

public interface MerchantService {

	public List<MerchantsDTO> getAll();

	Boolean findMerchant(MerchantsDTO m);

	Boolean deleteTK(MerchantsDTO m);
	
	public List<MerchantsDTO> getMerchantByMasterId(int master_id);
}
