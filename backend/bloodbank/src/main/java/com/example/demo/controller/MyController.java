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

import com.example.demo.module.BloodBank;
import com.example.demo.module.Donor;
import com.example.demo.module.RequestedBloodDonor;
import com.example.demo.myservice.MyService;
import com.example.demo.projection.DonorDataForAdmin;
import com.example.demo.projection.DonorRequiredData;
import com.example.demo.projection.StatusOfBloodRequest;
import com.example.demo.repository.DonorRepo;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	MyService service;
	
	@Autowired
	DonorRepo donorrepo;
	
	
	@RequestMapping("demo{username}")
	public int demo(@PathVariable String username)
	{
		return donorrepo.countByUsername(username);
	}
	

	@RequestMapping("bloodrequestaccepted{id}and{num}")
	public boolean bloodRequestAccepted(@PathVariable int id,@PathVariable int num)
	{
		try {
			
			service.requestOfBloodAccepted(id,num);
			
			return true;
		
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
	}
	

	@RequestMapping("allrequestedBloodData{num}")
	public List<RequestedBloodDonor> allRequestOfBlood(@PathVariable int num)
	{
		List<RequestedBloodDonor> requestedDonor = service.allBloodRequestedDonor(num);
		return requestedDonor;
		
	}

	
	
	@PostMapping("register")
	public int registerDonor(@RequestBody Donor donor)
	{
		try {
			return service.saveDonorDataInDB(donor);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}
	
	@PostMapping("registerBloodBank")
	public boolean registerBank(@RequestBody BloodBank bb)
	{
		try {
			
			return service.saveBloodBankDataInDB(bb);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("login{username}and{password}")
	public int login(@PathVariable String username,@PathVariable String password)
	{
		try {
			
			return service.loginDonor(username, password);
			
		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}
		
	}
	
	@GetMapping("banklogin{UIusername}/{UIpassword}")
	public int bloodBankLogin(@PathVariable String UIusername,@PathVariable String UIpassword) 
	{
		try {
			return service.banklogin(UIusername, UIpassword);
			
		} catch (Exception e) {

		e.printStackTrace();
		return -1;
		}
	}
	
	@GetMapping("getDonorData{UIusername}")
	public DonorRequiredData getDonorData(@PathVariable String UIusername){
		
		try {
			
			DonorRequiredData data=service.donorDataSendToUI(UIusername);
			
			return data;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		
		}
	}
	
	@RequestMapping("requestForBlood{userId}")
	public boolean requestForBlood(@PathVariable int userId,@RequestBody RequestedBloodDonor requestedBloodReceiver){

		try {
			
			service.saveRequestedBloodReceiverInDB(userId, requestedBloodReceiver);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
	@RequestMapping("statusOfBloodRequest{userId}")
	public List<StatusOfBloodRequest> getStatusOfBlood(@PathVariable int userId)
	{
		
		try {
			
			List<StatusOfBloodRequest> requestedBloodDataFromDB = service.getRequestedBloodDataFromDB(userId);
			
			return requestedBloodDataFromDB;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		
		}
	}
	
	@RequestMapping("getDonorDataForAdminDashboard")
	public List<DonorDataForAdmin> donorsData()
	{
		return service.donorsData();
	}
	
	@RequestMapping("countOfDonor{role}")
	public long donorCount(@PathVariable int role)
	{
		try {
			
			long donorInDB = service.registeredDonorInDB(role);
			return donorInDB;
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		
		}
	}
	
	
	@GetMapping("getCountOfCollectedBlood")
	public int getCountOfCollectedBlood()
	{
		try {
			int countBloodStore = service.getCountBloodStore();
			return countBloodStore;
			
		} catch (Exception e) {

		e.printStackTrace();
		return 0;
		}
	}
	
	
}
