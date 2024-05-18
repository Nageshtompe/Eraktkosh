package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.module.BloodDonationRequest;

@Repository
public interface BloodDonateRequestRepo extends JpaRepository<BloodDonationRequest, Integer> {
	
	
	@Query(value = "SELECT * FROM bloodbank.blood_donation_request where email=?1",nativeQuery = true)
	BloodDonationRequest getBloodAppointmentFromEmail(String email);

	@Query(value = "SELECT br.full_name,br.email,br.blood_type,br.health_conditions,br.id,br.phone,br.preferred_date,br.status from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as br on da.appointment_id=br.id  where donor_id=?1",nativeQuery = true)
	List<BloodDonationRequest> getAppointmentFromDB(int id);
	
	@Query(value = "SELECT br.full_name,br.email,br.blood_type,br.health_conditions,br.id,br.phone,br.preferred_date,br.status from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as br on da.appointment_id=br.id  where donor_id=?1 and br.status='pending'",nativeQuery = true)
	List<BloodDonationRequest> getdemo(int id);
	
	@Query(value ="SELECT br.appointment_date,br.action_form_id ,br.full_name,br.email,br.blood_type,br.health_conditions,br.id,br.phone,br.preferred_date,br.status from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as br on da.appointment_id=br.id  where donor_id=?1 and br.status='pending'",nativeQuery = true)
	List<BloodDonationRequest> getPendingAppointmentFromDB(int id);
	
	@Query(value = "SELECT br.full_name,br.email,br.blood_type,br.health_conditions,br.id,br.phone,br.preferred_date,br.status from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as br on da.appointment_id=br.id  where donor_id=?1 and br.status!='pending'",nativeQuery = true)
	List<BloodDonationRequest> getAllConfirmAppointmentFromDB(int donorID);
	
	@Query(value = "SELECT br.action_form_id,br.appointment_date ,br.full_name,br.email,br.blood_type,br.health_conditions,br.id,br.phone,br.preferred_date,br.status from bloodbank.donor as d join bloodbank.donor_appointment as da on d.id=da.donor_id join bloodbank.blood_donation_request as br on da.appointment_id=br.id  where donor_id=?1 and br.status!='pending'",nativeQuery = true)
	List<BloodDonationRequest> getAllConfirmAppointmentFromDB01(int donorID);
	
	@Query(value="SELECT * FROM bloodbank.blood_donation_request where status in('pending','confirm')",nativeQuery = true)
	List<BloodDonationRequest> getAllPendingAndConfirmAppointment();
	
	
	
	

	
	
}
