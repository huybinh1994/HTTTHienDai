package dao;

import java.util.List;

import model.MasterDTO;

public interface MasterDAO {

	public List<MasterDTO> getAll();
	public List<MasterDTO> getbyid(int id);
}
