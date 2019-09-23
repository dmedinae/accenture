package com.accenture.test.service;

import java.util.List;

import com.accenture.test.exception.RecordNotFoundException;
import com.accenture.test.model.ContractModel;

public interface ContractService {
	public List<ContractModel> getAll();
	public ContractModel create(ContractModel contract);
	public ContractModel update(ContractModel contract) throws RecordNotFoundException;
	public void delete(String id) throws RecordNotFoundException;
	public ContractModel get(String id) throws RecordNotFoundException;
}
