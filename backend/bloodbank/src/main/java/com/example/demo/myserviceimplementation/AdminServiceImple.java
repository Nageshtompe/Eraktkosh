package com.example.demo.myserviceimplementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.module.ActionForm;
import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Storage;
import com.example.demo.myservice.AdminService;
import com.example.demo.repository.ActionFormRepo;
import com.example.demo.repository.BloodDonateRequestRepo;
import com.example.demo.repository.RequestedBloodRepo;
import com.example.demo.repository.StorageRepo;

@Component
public class AdminServiceImple implements AdminService{

	@Autowired
	BloodDonateRequestRepo bloodappointment;
	
	@Autowired
	RequestedBloodRepo requestedbloodrepo;
	
	@Autowired
	ActionFormRepo actionFormRepo;
	
	@Autowired
	StorageRepo storageRepo;
	
	
	@Override
	public List<BloodDonationRequest> getAllAppointmentFromDB() {
		// TODO Auto-generated method stub
		return bloodappointment.getAllPendingAndConfirmAppointment();
	}


	@Override
	public int getCountOfPendingRequest(int num) {

		try {
			
			int pendingRequestFromDB = requestedbloodrepo.countOfPendingRequestFromDB(num);
			return pendingRequestFromDB;
			
		} catch (Exception e) {

		
		e.printStackTrace();
		return 8;
		}
		
	}


	@Override
	public boolean changeAppointmentStatusInDB(int apID) {

		try {
			
			BloodDonationRequest request = bloodappointment.getById(apID);
			request.setStatus("confirm");
			bloodappointment.save(request);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
		
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public boolean saveActionFormSubmittedInDB(int apID, ActionForm actionForm) {

		try {
			
			Storage storage=new Storage();
			System.out.println(storage);
			
					

			actionForm.setDateOfDonoting(new Date());
			
			
			System.out.println("in service");
			BloodDonationRequest appointment = bloodappointment.getById(apID);
			
			appointment.setStatus("completed");
			actionFormRepo.save(actionForm);
			storage.setBloodGroup(appointment.getBloodType());
			storage.setCollected(new Date());
			storage.setCurrentStatus("Available");
			Storage storage2 = storageRepo.save(storage);
			actionForm.setStorage(storage2);
		
			appointment.setActionForm(actionForm);
			bloodappointment.save(appointment);
			return true;
										
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
		
		
	}

	
}
