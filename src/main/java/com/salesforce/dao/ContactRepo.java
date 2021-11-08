package com.salesforce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.salesforce.model.Contact;

public interface ContactRepo extends CrudRepository<Contact, Integer> {

	@Query("select a from Contact a")
	List<Contact> findAll();

	@Query("select a from Contact a where a.name=:name OR a.email=:email")
	List<Contact> findAllByNameAndEmail(@Param("name") String name,@Param("email") String email);
	
	@Query(value = "SELECT * FROM CONTACT ct JOIN ASSOCIATED_CONTACTS act  ON ct.C_ID = act.C_ID WHERE act.O_ID =:oId", nativeQuery = true)
	List<Contact> findAssociatedConctsByOId(@Param("oId") int Oid);

	@Query(value = "delete from Associated_contacts where C_ID =:cId and O_ID =:oId", nativeQuery = true)
	@Modifying
	@Transactional
	void deleteAssociatedContactById(@Param("cId") int cId, @Param("oId") int oId);

	
	@Query(value = "SELECT * FROM CONTACT ct JOIN ASSOCIATED_CONTACTS act  ON ct.C_ID = act.C_ID WHERE act.O_ID !=:oId", nativeQuery = true)
	List<Contact> findContactsNotAssociated(@Param("oId") int Oid);

}
