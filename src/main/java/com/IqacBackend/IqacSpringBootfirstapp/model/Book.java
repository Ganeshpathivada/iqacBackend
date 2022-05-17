package com.IqacBackend.IqacSpringBootfirstapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import com.IqacBackend.IqacSpringBootfirstapp.model.dto.BookDto;

import lombok.Data;

@Data
@Entity
@Table
public class Book {  
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String titleOfBook;
	private String titleOfBookChapter;
	private long isbnNo;
	private long yearOfPublishing;
	private String nationalOrInternational;
	private String affiliatingInst;
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
	
	
	public static Book from(BookDto bookDto) {
	Book book = new Book();
	book.setNationalOrInternational(bookDto.getNationalOrInternational());
	book.setTitleOfBook(bookDto.getTitleOfBook());
	book.setTitleOfBookChapter(bookDto.getTitleOfBookChapter());
	book.setIsbnNo(bookDto.getIsbnNo());
	book.setYearOfPublishing(bookDto.getYearOfPublishing());
	book.setIsbnNo(bookDto.getIsbnNo());
	book.setAffiliatingInst(bookDto.getAffiliatingInst());
	return book;
}
	
	
	public static List<Book> from(List<BookDto> bookDto) {
		List<Book> books = new ArrayList<Book>();
		for(BookDto p :bookDto) {
			Book obj = new Book();
			obj.setNationalOrInternational(p.getNationalOrInternational());
			obj.setTitleOfBook(p.getTitleOfBook());
			obj.setTitleOfBookChapter(p.getTitleOfBookChapter());
			obj.setIsbnNo(p.getIsbnNo());
			obj.setYearOfPublishing(p.getYearOfPublishing());
			obj.setIsbnNo(p.getIsbnNo());
			obj.setAffiliatingInst(p.getAffiliatingInst());
			books.add(obj);
		}
		return books;
	}
	
}