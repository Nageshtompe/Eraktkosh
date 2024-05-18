package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.RequestedBloodDonor;
import com.example.demo.projection.StatusOfBloodRequest;


@Repository
public interface RequestedBloodRepo extends JpaRepository<RequestedBloodDonor, Integer> {
	
	
	
	@Query(value = "SELECT date_of_request as dateOfRequest ,patient_name as patientName,blood_type as bloodType,status_of_blood_requested as statusOfBloodRequested,requested_blood_response as requestedBloodResponse FROM bloodbank.requested_blood_donor where donor_id=?1",nativeQuery = true)
	public List<StatusOfBloodRequest> responseOfBloodRequest(int userId);
	
	@Query(value = "UPDATE `bloodbank`.`requested_blood_donor` SET `status_of_blood_requested` =?2 WHERE id = ?1",nativeQuery = true)
	public void bloodRequestAcceptedINDB(int id,int num);
	
	
	@Query(value = "SELECT * FROM bloodbank.requested_blood_donor where status_of_blood_requested=?1",nativeQuery = true)
	public List<RequestedBloodDonor> pendingRequestOfBlood(int num);
	
	@Query(value = "SELECT count(*) FROM bloodbank.requested_blood_donor where status_of_blood_requested=?1",nativeQuery = true)
	public int countOfPendingRequestFromDB(int num);
	
	

}
