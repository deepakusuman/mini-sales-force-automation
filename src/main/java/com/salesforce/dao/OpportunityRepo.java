package com.salesforce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.salesforce.model.Opportunity;

public interface OpportunityRepo extends CrudRepository<Opportunity, Integer>{
	
	
	@Query("select a from Opportunity a")
	List<Opportunity> findAll();
	
	@Query("select a from Opportunity a where a.name=:name OR a.account=:account")
	List<Opportunity> findAllByNameAndAccount(@Param("name") String name,@Param("account") String account);

}
