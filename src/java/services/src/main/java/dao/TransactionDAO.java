package dao;

import java.util.List;

import model.TransactionDTO;

public interface TransactionDAO {
	public void SaveTran(TransactionDTO dto);
	public List<TransactionDTO> getAll();
}
