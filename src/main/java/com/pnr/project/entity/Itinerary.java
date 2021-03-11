package com.pnr.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="itinerary")
public class Itinerary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
//	@Size(max = 2, message = "Air line code should be max 2 char")
	@Pattern(regexp = "[A-Z]{2}",message ="Airlinecode should be max 2 char" )
	@Column(name="airlinecode")
	private String airlinecode;
	
	@NotNull
	@Column(name="flightno")
	private int flightno;
	
	@Pattern(regexp = "[A-Z]")
	@Column(name="classofbooking")
	private String classofbooking;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name="dateoftravel")
	private Date dateoftravel;
	
	@NotNull
	@Column(name="origin")
	private String origin;
	
	@NotNull
	@Column(name="destination")
	private String destination;

	@NotNull
	@Column(name="numberofseat")
	private int numberofseat;
	
	public Itinerary() {
		
	}

	public Itinerary(String airlinecode,int flightno, String classofbooking, Date dateoftravel, String origin,
			String destination, int numberofseat) {
		super();
		this.airlinecode = airlinecode;
		this.flightno = flightno;
		this.classofbooking = classofbooking;
		this.dateoftravel = dateoftravel;
		this.origin = origin;
		this.destination = destination;
		this.numberofseat = numberofseat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlinecode() {
		return airlinecode;
	}

	public void setAirlinecode(String airlinecode) {
		this.airlinecode = airlinecode;
	}

	public int getFlightno() {
		return flightno;
	}

	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}

	public String getClassofbooking() {
		return classofbooking;
	}

	public void setClassofbooking(String classofbooking) {
		this.classofbooking = classofbooking;
	}

	public Date getDateoftravel() {
		return dateoftravel;
	}

	public void setDateoftravel(Date dateoftravel) {
		this.dateoftravel = dateoftravel;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberofseat() {
		return numberofseat;
	}

	public void setNumberofseat(int numberofseat) {
		this.numberofseat = numberofseat;
	}
	
	
	



}





















