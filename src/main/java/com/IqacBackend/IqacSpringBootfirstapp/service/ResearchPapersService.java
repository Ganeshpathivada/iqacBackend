package com.IqacBackend.IqacSpringBootfirstapp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IqacBackend.IqacSpringBootfirstapp.exception.ResourceNotFoundException;
import com.IqacBackend.IqacSpringBootfirstapp.model.ResearchPapers;
import com.IqacBackend.IqacSpringBootfirstapp.repository.ResearchPapersRepository;

@Service
public class ResearchPapersService {
    private final ResearchPapersRepository rpRepository;

	
    @Autowired
    public ResearchPapersService(ResearchPapersRepository rpRepository) {
		this.rpRepository = rpRepository;
	}
    
    public ResearchPapers addResearchPapers(ResearchPapers rp) {
		return rpRepository.save(rp);
	}
    
	public Iterable<ResearchPapers> addResearchPapers(List<ResearchPapers> rp) {
	return rpRepository.saveAll(rp);
	}
	public List<ResearchPapers> getResearchPapers(){
	return StreamSupport
			.stream(rpRepository.findAll().spliterator(), false)
			.collect(Collectors.toList());
	}
	public ResearchPapers getResearchPapers(Long id) {
		return rpRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("researchpapers not exist with id"+id));
	}
	
	public ResearchPapers deleteBook(Long id) {
		ResearchPapers rp = getResearchPapers(id);
		rpRepository.delete(rp);
	return rp;
    }
	
	@Transactional
	public ResearchPapers editResearchPapers(Long id,ResearchPapers rp) {
		ResearchPapers rpToEdit = getResearchPapers(id);
//		patentToEdit.setSerialNumber(patent.getSerialNumber());
		rpToEdit.setNationalOrInternational(rp.getNationalOrInternational());
		rpToEdit.setTitleOfThePapers(rp.getTitleOfThePapers());
		rpToEdit.setAcademicYear(rp.getAcademicYear());
		rpToEdit.setIssnNo(rp.getIssnNo());
		rpToEdit.setJournalnameVolPP(rp.getJournalnameVolPP());
		rpToEdit.setNameOfTheAuthors(rp.getNameOfTheAuthors());
		return rpToEdit;
	}
	
}
//@Service
//public class BookService {
//
//	private final BookRepository bookRepository;
//
//	@Autowired
//	public BookService(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}
//	public Book addBook(Book book) {
//		return bookRepository.save(book);
//	}
//	
//	public Iterable<Book> addBook(List<Book> book) {
//		return bookRepository.saveAll(book);
//	}
//	

//	
//	

//	

//}
