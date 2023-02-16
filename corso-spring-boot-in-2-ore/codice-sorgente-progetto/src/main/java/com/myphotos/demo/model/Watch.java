package com.myphotos.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


@Entity
public class Watch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String brand;
	@NotNull
	private String name;
	@NotBlank(message = "This field is required")
	@NotNull
	@Length(min = 2, message = "Min length is 2")	
	private String description;

	@NotNull
	private int price;
	@NotNull
	private String serial;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Watch() {
		
	}

	public Watch(int id, String brand, String name, String description, int price, String serial) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.description = description;
		this.price = price;
		this.serial = serial;
	}
}
