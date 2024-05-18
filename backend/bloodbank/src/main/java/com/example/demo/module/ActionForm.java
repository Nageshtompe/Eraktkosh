package com.example.demo.module;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity@Data@NoArgsConstructor@AllArgsConstructor@ToString
public class ActionForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	Date dateOfDonoting;
	int weight;
	String donorIdProof;
	String donorIddentityNumber;
	String bloodGroup;
	String name;
	int age;
	String healthCondition;
	int bloodQuantity;
	String documentType;
	
	@OneToOne
	Storage storage;
	
	
	
	

}
