package com.receiver.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Receiver {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "receiver_name", nullable = false, length = 20)
	private String name;
	@Column(name="dateRequired")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRequired;
	@Column(name="address", length = 30)
	private String address;
	
	public Receiver() {}
	
	public Receiver(Long id, String name, Date dateRequired, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dateRequired = dateRequired;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateRequired() {
		return dateRequired;
	}
	public void setDateRequired(Date dateRequired) {
		this.dateRequired = dateRequired;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		address = adress;
	}

	@Override
	public String toString() {
		return String.format("Receiver [id=%s, name=%s, dateRequired=%s, Address=%s]", id, name, dateRequired, address);
	}
	
	
	
	
	
}
