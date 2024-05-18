package com.example.demo.myservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Donor;
import com.example.demo.projection.HistoryOfBloodDonor;
import com.example.demo.repository.DonorRepo;


@Service
public interface DonorService {

	boolean cancelAppointment(int apID,int dID);
	
	int createAccountOfBloodBank(Donor donor);
	
	
	List<BloodDonationRequest> getConfirmAppointmentFromDB(int donorID);
	
	List<HistoryOfBloodDonor> getAllBloodHistoryFromDB(int donorID);
	
}
