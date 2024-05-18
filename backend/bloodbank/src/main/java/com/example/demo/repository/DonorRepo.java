package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.BloodBank;
import com.example.demo.module.Donor;
import com.example.demo.projection.DonorDataForAdmin;
import com.example.demo.projection.DonorRequiredData;
import com.example.demo.projection.HistoryOfBloodDonor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, Integer> {

	int countByUsername(String username);
	
	int countByRole(int role);
	
	
	
	@Query(value = "SELECT * FROM bloodbank.donor where username=?1",nativeQuery = true)
	Donor getDonorFromUsername(String username);
	
	
	@Query(value = "SELECT d.id,d.fullname,d.bloodgroup,d.mobilenumber,d.dob,d.gender,d.address,d.role,d.city FROM bloodbank.donor as d where username=?1",nativeQuery = true)
	DonorRequiredData donoDataSendToUI(String UIsername);
	
	@Query(value = "SELECT fullname,address,bloodgroup,TIMESTAMPDIFF(YEAR, dob, CURDATE()) as age,email_id as emailId,gender,mobilenumber FROM bloodbank.donor where role=1",nativeQuery = true)
	List<DonorDataForAdmin> donorData();
	
	@Query(value = "SELECT baf.date_of_donoting,baf.name,baf.blood_group,baf.weight FROM bloodbank.action_form as baf join bloodbank.blood_donation_request as bdr on bdr.action_form_id=baf.id where bdr.status='completed' and bdr.id in (select bdr.id from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as bdr on da.appointment_id=bdr.id where d.id=?1)",nativeQuery = true)
	public List<HistoryOfBloodDonor> getAllBloodHistoryOfDonor01(int donorid);
	
	
	@Query(value = "SELECT count(*) FROM bloodbank.blood_donation_request where status='completed'",nativeQuery = true)
	public int getCountOfBloodUnitStored();
	
	
	@Query(value="SELECT baf.date_of_donoting as dateOfDonoting,baf.name,baf.blood_group as bloodGroup,baf.weight FROM bloodbank.action_form as baf join bloodbank.blood_donation_request as bdr on bdr.action_form_id=baf.id where bdr.status='completed' and bdr.id in (select bdr.id from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as bdr on da.appointment_id=bdr.id where d.id=?1)",nativeQuery = true)
	public List<HistoryOfBloodDonor> getAllBloodHistoryOfDonor(int donorID);
	
}
