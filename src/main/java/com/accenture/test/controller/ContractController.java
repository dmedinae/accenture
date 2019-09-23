package com.accenture.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.exception.RecordNotFoundException;
import com.accenture.test.model.ContractModel;
import com.accenture.test.service.ContractService;

@RestController
public class ContractController {
	@Autowired
	ContractService contractService;
	
	@GetMapping("contracts")
	public ResponseEntity<List<ContractModel>> getAll() {
		List<ContractModel> contracts = contractService.getAll();
		return new ResponseEntity<List<ContractModel>>(contracts, HttpStatus.OK);
	}	
	
	@PostMapping("contract")
	public ResponseEntity<ContractModel> create(@RequestBody ContractModel contract) {
		return new ResponseEntity<ContractModel>(contractService.create(contract), HttpStatus.OK);
	}
	
	@GetMapping("contract/{id}")
	public ResponseEntity<ContractModel> get(@PathVariable String id) throws RecordNotFoundException {
		return new ResponseEntity<ContractModel>(contractService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("contract/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable String id) throws RecordNotFoundException {
		contractService.delete(id);
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", "Contract deleted");
		return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);		
	}
	
	@PutMapping("contract")
	public ResponseEntity<ContractModel> update(@RequestBody ContractModel contract) throws RecordNotFoundException {
		return new ResponseEntity<ContractModel>(contractService.update(contract), HttpStatus.OK);
	}
}
