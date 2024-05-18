package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.ActionForm;
import com.example.demo.module.BloodDonationRequest;
import com.example.demo.myservice.AdminService;
import com.example.demo.repository.BloodDonateRequestRepo;


@CrossOrigin("*")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@Autowired
	BloodDonateRequestRepo bloodappointment;
	

	@RequestMapping("actionFormSubmited{apID}")
	public boolean bactionFromSubmitted(@PathVariable int apID,@RequestBody ActionForm form)
	{
		try {
			
			System.out.println("in admin controller");
			boolean result = adminservice.saveActionFormSubmittedInDB(apID, form);
			return result;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
	}

	
	@GetMapping("getAllDonorsAppointments")
	public List<BloodDonationRequest> getAllAppointment(){
		try {
			
			List<BloodDonationRequest> appointmentFromDB = adminservice.getAllAppointmentFromDB();
			return appointmentFromDB;
			
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		
		}
	}
	
	
	
	@GetMapping("getCountOfRequest{num}")
	public int getCountOfPending(@PathVariable int num)
	{
		try {
			
			int count = adminservice.getCountOfPendingRequest(num);
			return count;
		} catch (Exception e) {

			e.printStackTrace();
			return 8;
		
		}
	}
	
	@GetMapping("changeAppointmentStaus{apID}")
	public boolean changeAppointmentStatus(@PathVariable int apID)
	{
		try {
			
			boolean statusInDB = adminservice.changeAppointmentStatusInDB(apID);
			return statusInDB;
			
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
	}

}
