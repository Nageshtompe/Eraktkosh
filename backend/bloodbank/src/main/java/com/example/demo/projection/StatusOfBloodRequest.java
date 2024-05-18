package com.example.demo.projection;

import java.util.Date;

public interface StatusOfBloodRequest {
	
	public Date getDateOfRequest();
	public String getPatientName();
	public String getBloodType();
	public int getStatusOfBloodRequested();
	public String getRequestedBloodResponse();
	

}
