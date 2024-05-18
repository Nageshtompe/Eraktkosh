package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.Storage;
import com.example.demo.projection.HistoryOfBloodDonor;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Integer>{
	
	

	
	
}
