package service;

import java.util.List;

import model.TransactionDTO;

public interface WatchingService {
	public void watching();
	public List<TransactionDTO> getAll();

}
