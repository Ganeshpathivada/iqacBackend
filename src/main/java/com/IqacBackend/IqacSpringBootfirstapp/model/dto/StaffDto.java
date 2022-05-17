package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;

import lombok.Data;

@Data
public class StaffDto {
	private Long id;
	private Long empNo;
	private String name;
	private String dpmt;
	private String gender;
	private String category;
	private String presentPosition;
	private Date dob;
	private Date doj;
	private Date dor;
	private String qualification;
	private int teachingExp;
	private int industrialExp;
	private String panNumber;
	private double aadharNumber;
	private long  phone;
	private String emailId;
	private List<PatentDto> patentDto = new ArrayList<>();
	private List<BookDto> bookDto = new ArrayList<>();
	private List<ResearchPapersDto> rpDto = new ArrayList<>();
	
	public List<PatentDto> getPatentDto() {
		return patentDto;
	}

	public void setPatentDto(List<PatentDto> patentDto) {
		this.patentDto = patentDto;
	}

	public List<BookDto> getBookDto() {
		return bookDto;
	}


	public void setBookDto(List<BookDto> bookDto) {
		this.bookDto = bookDto;
	}
	
	


	public List<ResearchPapersDto> getRpDto() {
		return rpDto;
	}

	public void setRpDto(List<ResearchPapersDto> rpDto) {
		this.rpDto = rpDto;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getEmpNo() {
		return empNo;
	}


	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
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


	public static StaffDto from(Staff staff) {
		StaffDto staffDto = new StaffDto();
		staffDto.setEmpNo(staff.getEmpNo());
		staffDto.setName(staff.getFullName());
		staffDto.setId(staff.getId());
		staffDto.setAadharNumber(staff.getAadharNumber());
		staffDto.setCategory(staff.getCategory());
		staffDto.setDob(staff.getDob());
		staffDto.setDoj(staff.getDoj());
		staffDto.setDor(staff.getDor());
		staffDto.setDpmt(staff.getDpmt());
		staffDto.setEmailId(staff.getEmailId());
		staffDto.setGender(staff.getGender());
		staffDto.setIndustrialExp(staff.getIndustrialExp());
		staffDto.setPanNumber(staff.getPanNumber());
		staffDto.setPhone(staff.getPhone());
		staffDto.setPresentPosition(staff.getPresentPosition());
		staffDto.setQualification(staff.getQualification());
		staffDto.setTeachingExp(staff.getTeachingExp());
		staffDto.setPatentDto(staff.getPatents().stream().map(PatentDto::from).collect(Collectors.toList()));
		staffDto.setBookDto(staff.getBook().stream().map(BookDto::from).collect(Collectors.toList()));
		staffDto.setRpDto(staff.getRp().stream().map(ResearchPapersDto::from).collect(Collectors.toList()));
		return staffDto;
	}
}

