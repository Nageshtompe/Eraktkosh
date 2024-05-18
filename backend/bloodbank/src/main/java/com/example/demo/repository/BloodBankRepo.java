package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.BloodBank;

@Repository
public interface BloodBankRepo extends JpaRepository<BloodBank, Integer> {
	
	//@Query(value = "SELECT count(*) FROM bloodbank.blood_bank where busername='?1'",nativeQuery = true
		int countByBusername(String UIusername);

	@Query(value ="SELECT * FROM bloodbank.blood_bank where busername=?1",nativeQuery = true)
	BloodBank getBloodBankFromUsername(String UIusername);

}
