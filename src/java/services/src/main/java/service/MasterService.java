package service;

import java.util.List;

import model.MasterDTO;

public interface MasterService {

	public List<MasterDTO> getAll();
	public List<MasterDTO> getbyid(int id);

}
