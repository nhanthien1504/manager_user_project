package com.example.User.Model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name ="Client_Number")
	private Long clientNumber;
	
	@Column(name = "Id_Number")
	@NotEmpty
	@Size(min = 0, max = 12)
	private String idNumber;
	
	@Column(name = "First_Name")
	@NotEmpty(message = "Field can't be empty!")
	@Size(min = 0, max = 10)
	private String firstName;
	
	@Column(name = "Last_Name")
	@NotEmpty
	@Size(min = 0, max = 60)
	private String lastName;
	
	@Column(name = "Gender")
	@Size(min = 0, max = 60)
	private String gender;
	
	@Column(name = "Birth_Day")
	@NotNull(message = "The date of birth is required.")
	@Past(message = "The date of birth must be in the past.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateBirthDay;
	
	@Column(name = "Salutation")
	@Size(min = 0, max = 30)
	private String salutation;
	
	@Column(name = "Marial_Status")
	@Size(min = 0, max = 30)
	private String marialStatus;
	
	@Column(name = "Address")
	@NotEmpty
	@Size(min = 0, max = 120)
	private String address;
	
	@Column(name ="Country")
	@NotEmpty
	@Size(min = 0, max = 60)
	private String country;

	public Long getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Long clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateBirthDay() {
		return dateBirthDay;
	}

	public void setDateBirthDay(LocalDate dateBirthDay) {
		this.dateBirthDay = dateBirthDay;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getMarialStatus() {
		return marialStatus;
	}

	public void setMarialStatus(String marialStatus) {
		this.marialStatus = marialStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public User(String idNumber,
			String firstName,
			String lastName,String gender,
			LocalDate dateBirthDay,
			String salutation, String marialStatus,
			String address,String country) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateBirthDay = dateBirthDay;
		this.salutation = salutation;
		this.marialStatus = marialStatus;
		this.address = address;
		this.country = country;
	}

	

	
	public User(long clientNumber, String idNumber,
			String firstName,
			String lastName, String gender,
			LocalDate dateBirthDay,
			String salutation, String marialStatus,
			String address, String country) {
		super();
		this.clientNumber = clientNumber;
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateBirthDay = dateBirthDay;
		this.salutation = salutation;
		this.marialStatus = marialStatus;
		this.address = address;
		this.country = country;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [clientNumber=" + clientNumber + ", idNumber=" + idNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateBirthDay=" + dateBirthDay + ", salutation="
				+ salutation + ", marialStatus=" + marialStatus + ", address=" + address + ", country=" + country + "]";
	}

	
	
	
	
}
