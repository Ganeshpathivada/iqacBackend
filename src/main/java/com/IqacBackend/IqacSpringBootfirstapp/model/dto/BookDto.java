package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

import java.util.Objects;

import com.IqacBackend.IqacSpringBootfirstapp.model.Book;

import lombok.Data;

@Data
public class BookDto {

	private long id;
	private String titleOfBook;
	private String titleOfBookChapter;
	private long isbnNo;
	private long yearOfPublishing;
	private String nationalOrInternational;
	private String affiliatingInst;
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


	public String getTitleOfBook() {
		return titleOfBook;
	}


	public void setTitleOfBook(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}


	public String getTitleOfBookChapter() {
		return titleOfBookChapter;
	}


	public void setTitleOfBookChapter(String titleOfBookChapter) {
		this.titleOfBookChapter = titleOfBookChapter;
	}


	public long getIsbnNo() {
		return isbnNo;
	}


	public void setIsbnNo(long isbnNo) {
		this.isbnNo = isbnNo;
	}


	public long getYearOfPublishing() {
		return yearOfPublishing;
	}


	public void setYearOfPublishing(long yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}


	public String getNationalOrInternational() {
		return nationalOrInternational;
	}


	public void setNationalOrInternational(String nationalOrInternational) {
		this.nationalOrInternational = nationalOrInternational;
	}


	public String getAffiliatingInst() {
		return affiliatingInst;
	}


	public void setAffiliatingInst(String affiliatingInst) {
		this.affiliatingInst = affiliatingInst;
	}
	
	
	
	public static BookDto from(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setNationalOrInternational(book.getNationalOrInternational());
		bookDto.setTitleOfBook(book.getTitleOfBook());
		bookDto.setTitleOfBookChapter(book.getTitleOfBookChapter());
		bookDto.setIsbnNo(book.getIsbnNo());
		bookDto.setYearOfPublishing(book.getYearOfPublishing());
		bookDto.setAffiliatingInst(book.getAffiliatingInst());
		if(Objects.nonNull(book.getStaff())) {
			bookDto.setPlainStaffDto(PlainStaffDto.from(book.getStaff()));
		}
		return bookDto;
	}
}
