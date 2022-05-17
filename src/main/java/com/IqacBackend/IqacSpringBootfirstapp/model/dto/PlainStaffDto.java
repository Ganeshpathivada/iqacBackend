package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

import java.util.Date;

import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;

import lombok.Data;

@Data
public class PlainStaffDto {
	private Long id;
	private String name;
	private String dpmt;
//	@Column(name ="gender")
	private String gender;
//	@Column(name="category")
	private String category;
//	@Column(name="present_position")
	private String presentPosition;
//	@Column(name="dob", nullable = true)
	private Date dob;
//	@Column(name="doj")
	private Date doj;
//	@Column(name="dor")
	private Date dor;
//	@Column(name ="qualification")
	private String qualification;
//	@Column(name="teaching_exp")
	private int teachingExp;
//	@Column(name="industrial_exp")
	private int industrialExp;
//	@Column(name="pan_number")
	private String panNumber;
//	@Column(name="aadhar_number")
	private double aadharNumber;
//	@Column(name ="phone")
	private long  phone;
//	@Column(name ="email_id")
	private String emailId;
	
	
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
	
	

	public String getDpmt() {
		return dpmt;
	}


	public void setDpmt(String dpmt) {
		this.dpmt = dpmt;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPresentPosition() {
		return presentPosition;
	}


	public void setPresentPosition(String presentPosition) {
		this.presentPosition = presentPosition;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public Date getDor() {
		return dor;
	}


	public void setDor(Date dor) {
		this.dor = dor;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public int getTeachingExp() {
		return teachingExp;
	}


	public void setTeachingExp(int teachingExp) {
		this.teachingExp = teachingExp;
	}


	public int getIndustrialExp() {
		return industrialExp;
	}


	public void setIndustrialExp(int industrialExp) {
		this.industrialExp = industrialExp;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public double getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(double aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public static PlainStaffDto from(Staff staff) {
		PlainStaffDto plainStaffDto = new PlainStaffDto();
		plainStaffDto.setId(staff.getId());
		plainStaffDto.setName(staff.getFullName());
		plainStaffDto.setAadharNumber(staff.getAadharNumber());
		plainStaffDto.setCategory(staff.getCategory());
		plainStaffDto.setDob(staff.getDob());
		plainStaffDto.setDoj(staff.getDoj());
		plainStaffDto.setDor(staff.getDor());
		plainStaffDto.setDpmt(staff.getDpmt());
		plainStaffDto.setEmailId(staff.getEmailId());
		plainStaffDto.setGender(staff.getGender());
		plainStaffDto.setIndustrialExp(staff.getIndustrialExp());
		plainStaffDto.setPanNumber(staff.getPanNumber());
		plainStaffDto.setPhone(staff.getPhone());
		plainStaffDto.setPresentPosition(staff.getPresentPosition());
		plainStaffDto.setQualification(staff.getQualification());
		plainStaffDto.setTeachingExp(staff.getTeachingExp());
		return plainStaffDto;
	}
	
}
