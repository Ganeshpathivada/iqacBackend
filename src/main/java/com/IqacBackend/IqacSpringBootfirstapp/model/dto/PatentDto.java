package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

//import java.util.Date;
import java.util.Objects;

//import javax.persistence.ManyToOne;

import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
//import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;

import lombok.Data;

@Data
public class PatentDto {
	private Long id;
//	private String serialNumber;
	private String title;
//	@Column(name="yearOfAward")
	private long yearOfAward;
//	@Column(name="nationalOrInternational")
	private String nationalOrInternational;
//	@Column(name="status")
	private String status;
	private PlainStaffDto plainStaffDto;
	
	
	public PlainStaffDto getPlainStaffDto() {
		return plainStaffDto;
	}


	public void setPlainStaffDto(PlainStaffDto plainStaffDto) {
		this.plainStaffDto = plainStaffDto;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getYearOfAward() {
		return yearOfAward;
	}


	public void setYearOfAward(long yearOfAward) {
		this.yearOfAward = yearOfAward;
	}


	public String getNationalOrInternational() {
		return nationalOrInternational;
	}

	
	public void setNationalOrInternational(String nationalOrInternational) {
		this.nationalOrInternational = nationalOrInternational;
	}

 
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public static PatentDto from(Patents patent) {
		PatentDto patentDto = new PatentDto();
		patentDto.setId(patent.getId());
		patentDto.setNationalOrInternational(patent.getNationalOrInternational());
		patentDto.setStatus(patent.getStatus());
		patentDto.setTitle(patent.getTitle());
		patentDto.setYearOfAward(patent.getYearOfAward());
		if(Objects.nonNull(patent.getStaff())) {
			patentDto.setPlainStaffDto(PlainStaffDto.from(patent.getStaff()));
		}
		return patentDto;
	}
}
