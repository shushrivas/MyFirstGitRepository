package com.clc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "StudentIdInfo")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
@Size(max = 4,message = "please Enter charecter less than 5")
	private String studName;
@Email
	private String studAddress;
 @Size(min = 0,max = 10)
	private String studMobileNumber;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public Student() {
		super();
	}

	public Student(int studId, String studName, String studAddress, String studMobileNumber) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		this.studMobileNumber = studMobileNumber;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudAddress() {
		return studAddress;
	}

	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}

	public String getStudMobileNumber() {
		return studMobileNumber;
	}

	public void setStudMobileNumber(String studMobileNumber) {
		this.studMobileNumber = studMobileNumber;
	}

	@Override
	public String toString() {
		return "\n Student [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress
				+ ", studMobileNumber=" + studMobileNumber + "]";
	}

}
