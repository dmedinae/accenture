package com.accenture.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.test.exception.RecordNotFoundException;
import com.accenture.test.model.ContractModel;
import com.accenture.test.repository.ContractRepository;
import com.accenture.test.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	ContractRepository contractRepository;	
	
	@Override
	public List<ContractModel> getAll() {
		List<ContractModel> contracts = contractRepository.findAll();
		if(contracts.size() > 0) {
            return contracts;
        }
		return new ArrayList<ContractModel>();
	}
	
	@Override
	public ContractModel create(ContractModel contract) {
		return contractRepository.save(contract);
	}
	
	@Override
	public ContractModel update(ContractModel contract) throws RecordNotFoundException {
		Optional<ContractModel> contractCheck = contractRepository.findById(contract.getId());
		if (!contractCheck.isPresent()) throw new RecordNotFoundException("No contract record exist for given id");
		contract.setCreatedAt(contractCheck.get().getCreatedAt());		
		return contractRepository.save(contract);
	}
	
	@Override
	public ContractModel get(String id) throws RecordNotFoundException {
		Optional<ContractModel> contract = contractRepository.findById(id);
		if (!contract.isPresent()) throw new RecordNotFoundException("No contract record exist for given id");
		return contract.get();
	}
	
	@Override
	public void delete(String id) throws RecordNotFoundException {
		Optional<ContractModel> contractCheck = contractRepository.findById(id);
		if (!contractCheck.isPresent()) throw new RecordNotFoundException("No contract record exist for given id");
		contractRepository.deleteById(id);
	}	
	
}
