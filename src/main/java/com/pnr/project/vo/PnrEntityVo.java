package com.pnr.project.vo;

import java.util.Date;

public class PnrEntityVo {
	
	private int id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String contact;
	private String timelimit;
	private String receivedfrom;

	private AddressVo address;
	
	private ItineraryVo  itinerary;
	
	public PnrEntityVo() {
		
	}
	
	
	public PnrEntityVo(int id, String firstName, String lastName, Date dob, String contact, String timelimit,
			String receivedfrom) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.contact = contact;
		this.timelimit = timelimit;
		this.receivedfrom = receivedfrom;
	}
	
	
	
	
	
	public AddressVo getAddress() {
		return address;
	}


	public void setAddress(AddressVo address) {
		this.address = address;
	}


	public ItineraryVo getItinerary() {
		return itinerary;
	}


	public void setItineraryVo(ItineraryVo itinerary) {
		this.itinerary = itinerary;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}
	public String getReceivedfrom() {
		return receivedfrom;
	}
	public void setReceivedfrom(String receivedfrom) {
		this.receivedfrom = receivedfrom;
	}
	
	

}
