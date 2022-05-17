package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

import java.util.Objects;

import com.IqacBackend.IqacSpringBootfirstapp.model.ResearchPapers;

import lombok.Data;

@Data
public class ResearchPapersDto {

	private Long id;
	private String nameOfTheAuthors;
	private String titleOfThePapers;
	private String journalnameVolPP; 
	private long issnNo;
	private String nationalOrInternational;
	private long academicYear;
    private PlainStaffDto plainStaffDto;
	
	public PlainStaffDto getPlainStaffDto() {
		return plainStaffDto;
	}


	public void setPlainStaffDto(PlainStaffDto plainStaffDto) {
		this.plainStaffDto = plainStaffDto;
	}
	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNameOfTheAuthors() {
		return nameOfTheAuthors;
	}


	public void setNameOfTheAuthors(String nameOfTheAuthors) {
		this.nameOfTheAuthors = nameOfTheAuthors;
	}


	public String getTitleOfThePapers() {
		return titleOfThePapers;
	}


	public void setTitleOfThePapers(String titleOfThePapers) {
		this.titleOfThePapers = titleOfThePapers;
	}


	public String getJournalnameVolPP() {
		return journalnameVolPP;
	}


	public void setJournalnameVolPP(String journalnameVolPP) {
		this.journalnameVolPP = journalnameVolPP;
	}


	public long getIssnNo() {
		return issnNo;
	}


	public void setIssnNo(long issnNo) {
		this.issnNo = issnNo;
	}


	public String getNationalOrInternational() {
		return nationalOrInternational;
	}


	public void setNationalOrInternational(String nationalOrInternational) {
		this.nationalOrInternational = nationalOrInternational;
	}


	public long getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(long academicYear) {
		this.academicYear = academicYear;
	}


	public static ResearchPapersDto from(ResearchPapers rp) {
		ResearchPapersDto rpDto = new ResearchPapersDto();
		rpDto.setId(rp.getId());
		rpDto.setAcademicYear(rp.getAcademicYear());
		rpDto.setIssnNo(rp.getIssnNo());
		rpDto.setJournalnameVolPP(rp.getJournalnameVolPP());
		rpDto.setNameOfTheAuthors(rp.getNameOfTheAuthors());
		rpDto.setNationalOrInternational(rp.getNationalOrInternational());
		rpDto.setTitleOfThePapers(rp.getTitleOfThePapers());
		if(Objects.nonNull(rp.getStaff())) {
			rpDto.setPlainStaffDto(PlainStaffDto.from(rp.getStaff()));	
	    }
		return  rpDto;
	} 
}
