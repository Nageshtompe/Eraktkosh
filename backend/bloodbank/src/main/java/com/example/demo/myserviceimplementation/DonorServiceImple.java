package com.example.demo.myserviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Donor;
import com.example.demo.myservice.DonorService;
import com.example.demo.projection.HistoryOfBloodDonor;
import com.example.demo.repository.BloodDonateRequestRepo;
import com.example.demo.repository.DonorRepo;

@Component
public class DonorServiceImple implements DonorService{
	
	@Autowired
	DonorRepo donorrepo;
	
	@Autowired
	BloodDonateRequestRepo bloodappointment;

	@Override
	public boolean cancelAppointment(int apID, int dID) {
		// TODO Auto-generated method stub
	
		try {
			
			Donor donor = donorrepo.getById(dID);
//			System.out.println(donor);
			BloodDonationRequest donationRequest = bloodappointment.getById(apID);
			if(donationRequest.getStatus().equals("pending"))
			{
				donor.getAppointment().remove(donationRequest);
				bloodappointment.deleteById(apID);
				System.out.println(donationRequest);
				donorrepo.save(donor);
				return true;
			}
			else
			{
				return false;
			}
//			System.out.println(donationRequest);
			
//			for(int i=0;i<list.size();i++)
//			{
//				if(list.get(i).getId()==donationRequest.getId())
//				{
//					list.remove(i);
//					donor.setAppointment(list);
//					donorrepo.save(donor);
//					return true;
//				}
//			}
				
		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<BloodDonationRequest> getConfirmAppointmentFromDB(int donorID) {
		// TODO Auto-generated method stub
		try {
		
			List<BloodDonationRequest> confirmAppointmentFromDB = bloodappointment.getAllConfirmAppointmentFromDB01(donorID);
			return confirmAppointmentFromDB;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<HistoryOfBloodDonor> getAllBloodHistoryFromDB(int donorID) {
		try {
			
			List<HistoryOfBloodDonor> allBloodHistoryOfDonor = donorrepo.getAllBloodHistoryOfDonor(donorID);
			return allBloodHistoryOfDonor;
		} catch (Exception e) {

			e.printStackTrace();// TODO: handle exception
			return null;
		}
	}

	@Override
	public int createAccountOfBloodBank(Donor donor) {
		
		try {
			
			int bloodabnk = donorrepo.countByUsername(donor.getUsername());
			if(bloodabnk==0)
			{
				donor.setRole(2);
				donorrepo.save(donor);		
				return 1;					//registration succefulll
			}
			else if(bloodabnk==1)
			{
				return 2;		//already registered
			}else
			{
				return 0;			//something error
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}
	


}
