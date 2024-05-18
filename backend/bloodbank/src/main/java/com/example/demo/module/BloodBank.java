package com.example.demo.module;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity@Data@NoArgsConstructor@AllArgsConstructor@ToString
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bid;
	String bname;
	String busername;
	String bpassword;
	String baddress;
	long bmobilenumber;
	String bcity;
	String bemail;
	
	@OneToMany
	List<Storage> storage;
		

}
