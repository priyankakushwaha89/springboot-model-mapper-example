package com.demo.springboot_model_mapper_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="customer")
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 int id;
 String name;
 String city;
 int orderdate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getOrderdate() {
	return orderdate;
}
public void setOrderdate(int orderdate) {
	this.orderdate = orderdate;
}
 
 
}
