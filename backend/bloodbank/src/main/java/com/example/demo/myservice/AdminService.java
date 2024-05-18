package com.example.demo.myservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.module.ActionForm;
import com.example.demo.module.BloodDonationRequest;

@Service
public interface AdminService {

	public List<BloodDonationRequest> getAllAppointmentFromDB();
	
	public int getCountOfPendingRequest(int num);
	
	public boolean changeAppointmentStatusInDB(int apID);
	
	public boolean saveActionFormSubmittedInDB(int apID,ActionForm actionForm);
}
