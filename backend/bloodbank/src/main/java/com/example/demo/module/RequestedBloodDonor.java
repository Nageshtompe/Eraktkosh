package com.example.demo.module;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@Entity@ToString@AllArgsConstructor@NoArgsConstructor
public class RequestedBloodDonor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;			//unique id for blood request
	String patientName;		
	int patientAge;
	String patientGender;
	String hospitalName;			//where the patient is admited 
	long hospitalContactNumber;			
	String bloodType;					//type of blood require
//	int bloodQuentity;					//amount blood require
	Date neededDate;					//when the blood is require
	String emergencyStatus;				//emergency or non emergency
	long patientContactNumber;				
	
	int donorId;		//requested donor id which user is requested for blood
	String requestedBloodResponse;			//query response message and where  the receipant are take blood 
	int statusOfBloodRequested;			//1-pending	2-accepted	3-rejected	4-collected
	Date dateOfRequest;					//when the receipant are request for blood
	
	
	
}
