package com.IqacBackend.IqacSpringBootfirstapp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IqacBackend.IqacSpringBootfirstapp.exception.ResourceNotFoundException;
import com.IqacBackend.IqacSpringBootfirstapp.model.Book;
import com.IqacBackend.IqacSpringBootfirstapp.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Iterable<Book> addBook(List<Book> book) {
		return bookRepository.saveAll(book);
	}
	
	public List<Book> getBook(){
		return StreamSupport
				.stream(bookRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("book not exist with id"+id));
	}
	
	public Book deleteBook(Long id) {
		Book book = getBook(id);
		bookRepository.delete(book);
		return book;
	}
	
	@Transactional
	public Book editBook(Long id,Book book) {
		Book bookToEdit = getBook(id);
//		patentToEdit.setSerialNumber(patent.getSerialNumber());
		bookToEdit.setNationalOrInternational(book.getNationalOrInternational());
		bookToEdit.setTitleOfBook(book.getTitleOfBook());
		bookToEdit.setTitleOfBookChapter(book.getTitleOfBookChapter());
		bookToEdit.setIsbnNo(book.getIsbnNo());
		bookToEdit.setYearOfPublishing(book.getYearOfPublishing());
		bookToEdit.setAffiliatingInst(book.getAffiliatingInst());
		return bookToEdit;
	}
}
