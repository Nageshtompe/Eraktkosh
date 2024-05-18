package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Donor;
import com.example.demo.myservice.DonorService;
import com.example.demo.myservice.MyService;
import com.example.demo.projection.HistoryOfBloodDonor;

import lombok.experimental.PackagePrivate;

@CrossOrigin
@RestController
public class DonorController {


	@Autowired
	MyService service;

	@Autowired
	DonorService donorservice;
	
	
	@PostMapping("CreateBloodBank")
	public int CreateBloodBank(@RequestBody Donor donor)
	{
		try {
			
			return donorservice.createAccountOfBloodBank(donor);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}


	@GetMapping("getConfirmAppointmentList{donorID}")
	public List<BloodDonationRequest> getConfirmAppointment(@PathVariable int donorID)
	{
		try {

			List<BloodDonationRequest> listOfConfirmAppointment = donorservice.getConfirmAppointmentFromDB(donorID);
			return listOfConfirmAppointment;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}


	@PostMapping("donateAppointment{id}")
	public boolean donateappointment(@PathVariable int id ,@RequestBody BloodDonationRequest donaterequest)
	{
		try {

			service.donateBloodRequestInDB(id,donaterequest);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	@GetMapping("getAppointmentList{id}")
	public List<BloodDonationRequest> getListOfAppointment(@PathVariable int id)
	{
		try {

			List<BloodDonationRequest> appointment = service.getAllAppointmentFromDB(id);
			return appointment;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	@GetMapping("cancelAppointment{apID}and{dID}")
	public boolean cancelApointment(@PathVariable int apID,@PathVariable int dID)
	{
		try {

			boolean result = donorservice.cancelAppointment(apID, dID);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@GetMapping("getAllHistoryOfBloodDonorFromDB{donorID}")
	public List<HistoryOfBloodDonor> getAllHistoryOfBloodDonorFromDB(@PathVariable int donorID){
		try {
			
			List<HistoryOfBloodDonor> allBloodHistoryFromDB = donorservice.getAllBloodHistoryFromDB(donorID);
			return allBloodHistoryFromDB;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}





}
