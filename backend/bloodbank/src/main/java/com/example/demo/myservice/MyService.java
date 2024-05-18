package com.example.demo.myservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.module.BloodBank;
import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Donor;
import com.example.demo.module.RequestedBloodDonor;
import com.example.demo.projection.DonorDataForAdmin;
import com.example.demo.projection.DonorRequiredData;
import com.example.demo.projection.StatusOfBloodRequest;

@Service
public interface MyService {
	
	public  int getCountBloodStore();
	
	public int saveDonorDataInDB(Donor donor);
	
	public boolean saveBloodBankDataInDB(BloodBank bb);
	
	public int loginDonor(String username,String password);
	
	public int banklogin(String UIusername,String UIpassword);
	
	public DonorRequiredData donorDataSendToUI(String UIusername);
	
	public boolean saveRequestedBloodReceiverInDB(int userId,RequestedBloodDonor requestedBloodReceiver);
	
	public List<StatusOfBloodRequest> getRequestedBloodDataFromDB(int userId);
	
	public List<DonorDataForAdmin> donorsData();
	
	public long registeredDonorInDB(int role);
	
	public List<RequestedBloodDonor> allBloodRequestedDonor(int num);
	
	public boolean requestOfBloodAccepted(int id,int num);
	
	public boolean donateBloodRequestInDB(int id,BloodDonationRequest donaterequest);
	
	public List<BloodDonationRequest> getAllAppointmentFromDB(int id);
}
