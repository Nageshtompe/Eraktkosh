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
public class Storage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	Date collected;
	Date delivaredDate;
	String bloodGroup;
	String currentStatus; //availble or delivered  or expired
	
//	@OneToOne
//	ActionForm acformForm;
//	
	
}
