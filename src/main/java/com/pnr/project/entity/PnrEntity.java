package com.pnr.project.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pnrentity")
public class PnrEntity  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GenericGenerator(name = "incr",strategy = "increment")
	@ApiModelProperty(notes = "The database generated entity ID")
	@Column(name="id")
	private int id;
	
	@NotNull(message = "First Name Required")
	@Size(max = 30)
	@ApiModelProperty(notes = "The database generated First Name")
	@Column(name="firstname")
	private String firstName;
	
	@NotNull(message = "LastName required")
	@ApiModelProperty(notes = "Passenger Last Name")
	@Column(name="lastname")
	@Size(max = 20)
	private String lastName;
	
	@NotNull(message = "dob should not be blank")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@ApiModelProperty(notes = "passenger DOB")
	@Column(name="dob")
	private Date dob;
	
	@NotNull
	@Pattern(regexp = "(0191)?[7-9][0-9]{9}")
	@ApiModelProperty(notes = "Passenger contact no")
	@Column(name="contact")
	private String contact;
	
	@ApiModelProperty(notes = "Time Limit")
	@Column(name="timelimit")
	private String timelimit;
	
	@ApiModelProperty(notes = "Received From")
	@Column(name="receivedfrom")
	private String receivedfrom;
	
	@Column(name = "address_id")
	private int address_id; 
	
	
	
	
	// creation date time
	//update date time
	
	@OneToOne(targetEntity = Itinerary.class, cascade = CascadeType.ALL)
	private Itinerary itinerary;
	
/*	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "address_id")
	private Address address;
*/	
	
	
	public PnrEntity() {
		
	}

	public PnrEntity( int id ,String firstName, String lastName, Date dob, String contact, String timelimit, String receivedfrom , int address_id) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	//	this.address = address;
		this.contact = contact;
		this.timelimit = timelimit;
		this.receivedfrom = receivedfrom;
		this.address_id = address_id;
	}
	
	

	
//	public Set<Address> getAddress() {
//		return address;
//	}
//
//	public void setAddress(Set<Address> address) {
//		this.address = address;
//	}

/*	public com.ssr.project.entity.Address getAddress() {
		return address;
	}

	public void setAddress(com.ssr.project.entity.Address address) {
		this.address = address;
	}
*/
	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

 
	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
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

	

//	@Override
//	public String toString() {
//		return "PnrEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
//				+ ", address=" + address + ", contact=" + contact + "]";
//	}
	

	
	
	
	
	
	

}
