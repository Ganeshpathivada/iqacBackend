package com.IqacBackend.IqacSpringBootfirstapp.model;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.IqacBackend.IqacSpringBootfirstapp.model.dto.ResearchPapersDto;

import lombok.Data;

@Data
@Entity
@Table
public class ResearchPapers {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameOfTheAuthors;
	private String titleOfThePapers;
	private String journalnameVolPP; 
	private long issnNo;
	private String nationalOrInternational;
	private long academicYear;
	
//	@ManyToOne
//	private Staff staff;
//    public Staff getStaff() {
//		return staff;
//	}
//	public void setStaff(Staff staff) {
//		this.staff = staff;
//	}
	
	@ManyToOne
	private Staff staff;
    public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
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
	public static ResearchPapers from(ResearchPapersDto rpDto) {
		ResearchPapers rp = new ResearchPapers();
		rp.setNameOfTheAuthors(rpDto.getNameOfTheAuthors());
		rp.setAcademicYear(rpDto.getAcademicYear());
		rp.setIssnNo(rpDto.getIssnNo());
		rp.setJournalnameVolPP(rpDto.getJournalnameVolPP());
		rp.setNationalOrInternational(rpDto.getNationalOrInternational());
		rp.setTitleOfThePapers(rpDto.getTitleOfThePapers());
		return rp;
	}
	
	public static List<ResearchPapers> from(List<ResearchPapersDto> rpDto){
		List<ResearchPapers> rp = new ArrayList<>();
		for(ResearchPapersDto r:rpDto) {
			ResearchPapers obj = new ResearchPapers();
			obj.setNameOfTheAuthors(r.getNameOfTheAuthors());
			obj.setTitleOfThePapers(r.getTitleOfThePapers());
			obj.setIssnNo(r.getIssnNo());
			obj.setAcademicYear(r.getAcademicYear());
			obj.setJournalnameVolPP(r.getJournalnameVolPP());
			obj.setNationalOrInternational(r.getNationalOrInternational());
			rp.add(obj);
		}
		return rp;
	}
}

//	public static Book from(BookDto bookDto) {
//	Book book = new Book();
//	book.setNationalOrInternational(bookDto.getNationalOrInternational());
//	book.setTitleOfBook(bookDto.getTitleOfBook());
//	book.setTitleOfBookChapter(bookDto.getTitleOfBookChapter());
//	book.setIsbnNo(bookDto.getIsbnNo());
//	book.setYearOfPublishing(bookDto.getYearOfPublishing());
//	book.setIsbnNo(bookDto.getIsbnNo());
//	book.setAffiliatingInst(bookDto.getAffiliatingInst());
//	return book;
//}
//	
//	
//	public static List<Book> from(List<BookDto> bookDto) {
//		List<Book> books = new ArrayList<Book>();
//		for(BookDto p :bookDto) {
//			Book obj = new Book();
//			obj.setNationalOrInternational(p.getNationalOrInternational());
//			obj.setTitleOfBook(p.getTitleOfBook());
//			obj.setTitleOfBookChapter(p.getTitleOfBookChapter());
//			obj.setIsbnNo(p.getIsbnNo());
//			obj.setYearOfPublishing(p.getYearOfPublishing());
//			obj.setIsbnNo(p.getIsbnNo());
//			obj.setAffiliatingInst(p.getAffiliatingInst());
//			books.add(obj);
//		}
//		return books;
//	}
//	
//}