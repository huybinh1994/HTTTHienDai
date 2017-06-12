package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MasterDAO;
import model.MasterDTO;

@Service
public class MasterServiceImpl implements MasterService{

	MasterDAO master;
	
	public MasterDAO getMaster() {
		return master;
	}
	@Autowired
	public void setMaster(MasterDAO master) {
		this.master = master;
	}

	@Override
	public List<MasterDTO> getAll() {
		// TODO Auto-generated method stub
		return master.getAll();
	}
	@Override
	public List<MasterDTO> getbyid(int id){
		// TODO Auto-generated method stub
		return master.getbyid(id);
	}
}
