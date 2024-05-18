package com.example.demo.myserviceimplementation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.module.BloodBank;
import com.example.demo.module.BloodDonationRequest;
import com.example.demo.module.Donor;
import com.example.demo.module.RequestedBloodDonor;
import com.example.demo.myservice.MyService;
import com.example.demo.projection.DonorDataForAdmin;
import com.example.demo.projection.DonorRequiredData;
import com.example.demo.projection.StatusOfBloodRequest;
import com.example.demo.repository.BloodBankRepo;
import com.example.demo.repository.BloodDonateRequestRepo;
import com.example.demo.repository.DonorRepo;
import com.example.demo.repository.RequestedBloodRepo;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;

@Component
public class MyServiceImple implements MyService{

	@Autowired
	DonorRepo donorrepo;

	@Autowired
	BloodBankRepo bloodbankrepo;

	@Autowired
	RequestedBloodRepo requestedbloodrepo;

	@Autowired
	BloodDonateRequestRepo bloodappointment;


	@Override
	public int saveDonorDataInDB(Donor donor) {
		try {

			int count = donorrepo.countByUsername(donor.getUsername());
			if(count==0)
			{
				donor.setRole(1);
				donorrepo.save(donor);
				return 1;
			}
			else if(count==1)
			{
				return 2;		//already registered
			}
			else
			{
				return 0;		//something error
			}



		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int loginDonor(String username, String password) {

		try {

			int cnt=donorrepo.countByUsername(username);
			if(cnt==1)
			{
				Donor donor = donorrepo.getDonorFromUsername(username);
				if(donor.getUsername().equals(username)&&donor.getPassword().equals(password))
				{
					if(donor.getRole()==1)
					{
						return 11;		//login succesfull return the donor
					}else if(donor.getRole()==2)
					{
						return 22;			//this is blood bank login
					}
					else if(donor.getRole()==3)
					{
						return 33;			//root login
					}
					else
					{
						return 0;			//error
					}
				}
				else
				{
					return 2;		//wrong password
				}
			}
			else
			{
				return 0;		//wrong username
			}

		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public boolean saveBloodBankDataInDB(BloodBank bb) {

		try {


			bloodbankrepo.save(bb);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}


	}

	@Override
	public int banklogin(String UIusername, String UIpassword) {

		int countByBusername = bloodbankrepo.countByBusername(UIusername);
		if(countByBusername==1)
		{
			BloodBank bb = bloodbankrepo.getBloodBankFromUsername(UIusername);
			if(bb.getBusername().equals(UIusername)&&bb.getBpassword().equals(UIpassword))
			{
				return 1;
			}else
			{
				return 2;
			}
		}
		return -1;



	}

	@Override
	public DonorRequiredData donorDataSendToUI(String UIusername) {
		try {
			return donorrepo.donoDataSendToUI(UIusername);
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	@Override
	public boolean saveRequestedBloodReceiverInDB(int userId, RequestedBloodDonor requestedBloodReceiver) {

		try {

			requestedBloodReceiver.setDateOfRequest(new Date());
			requestedBloodReceiver.setDonorId(userId);
			requestedBloodReceiver.setStatusOfBloodRequested(1);
			requestedBloodReceiver.setRequestedBloodResponse("NA");
			requestedbloodrepo.save(requestedBloodReceiver);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}


	}

	@Override
	public List<StatusOfBloodRequest> getRequestedBloodDataFromDB(int userId) {

		try {

			System.out.println("in implementation");
			List<StatusOfBloodRequest> responseOfBloodRequest = requestedbloodrepo.responseOfBloodRequest(userId);
			System.out.println("in done after imple");

			System.out.println(responseOfBloodRequest);
			return responseOfBloodRequest;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}


	}

	@Override
	public List<DonorDataForAdmin> donorsData() {


		return donorrepo.donorData();
	}

	@Override
	public long registeredDonorInDB(int role) {

		try {

			long count = donorrepo.countByRole(role);
			return count;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;

		}

	}

	@Override
	public List<RequestedBloodDonor> allBloodRequestedDonor(int num) {

		try {
			return requestedbloodrepo.pendingRequestOfBlood(num);
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	@Override
	public boolean requestOfBloodAccepted(int id,int num) {

		try {

			RequestedBloodDonor request = requestedbloodrepo.getById(id);
			request.setStatusOfBloodRequested(num);
			requestedbloodrepo.save(request);
			//			requestedbloodrepo.bloodRequestAcceptedINDB(id,num);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean donateBloodRequestInDB(int id,BloodDonationRequest donaterequest) {
		try {

			donaterequest.setStatus("pending");
			donaterequest.setAppointmentDate(new Date());


			bloodappointment.save(donaterequest);
			Donor donor = donorrepo.getById(id);
			BloodDonationRequest appointmentrequest = bloodappointment.getById(donaterequest.getId());
			List<BloodDonationRequest> appointment = donor.getAppointment();
			System.out.println("in reqyuest");
			System.out.println(appointmentrequest);
			System.out.println("in donor");
			System.out.println(donor);
			appointment.add(appointmentrequest);
			donorrepo.save(donor);

			//			bloodappointment.save(donaterequest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public List<BloodDonationRequest> getAllAppointmentFromDB(int id) {

		try {


			List<BloodDonationRequest> appointmentFromDB = bloodappointment.getPendingAppointmentFromDB(id);
			//			List<BloodDonationRequest> demo = bloodappointment.getDemo(id);
			return appointmentFromDB;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	@Override
	public int getCountBloodStore() {
		try {
			int countOfBloodUnitStored = donorrepo.getCountOfBloodUnitStored();
			return countOfBloodUnitStored;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
