package com.example.demo.module;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor@ToString
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String fullname;
	String username;
    String password;
    String emailId;
    long mobilenumber;
    Date dob;
    String gender;
    String city;
    String address;
    int role;			//1-Donor	2-Blood Bank	3-root

    @OneToMany
   List<BloodDonationRequest> appointment;
    
    @OneToMany
   List<ActionForm> actionForm;

}
