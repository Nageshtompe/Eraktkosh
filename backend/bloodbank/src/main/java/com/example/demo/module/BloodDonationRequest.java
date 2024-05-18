package com.example.demo.module;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Data@NoArgsConstructor@AllArgsConstructor@ToString
public class BloodDonationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fullName;
	String email;
	String phone;
	String bloodType;
	Date preferredDate;
	String healthConditions;
	String status;
	Date appointmentDate;
	
	@OneToOne
	ActionForm actionForm;
	

	
}
