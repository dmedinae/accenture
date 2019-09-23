package com.accenture.test.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.test.model.ContractModel;

@Repository
public interface ContractRepository extends MongoRepository<ContractModel, String>{
	@Query(value="{'employeName':?0}")
	Optional<ContractModel> findByemployeName(String employeName);
}
