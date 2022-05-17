package com.IqacBackend.IqacSpringBootfirstapp.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

//import org.apache.pdfbox.contentstream.operator.state.Save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IqacBackend.IqacSpringBootfirstapp.exception.ResourceNotFoundException;
import com.IqacBackend.IqacSpringBootfirstapp.exception.patentIsAlreadyAssignedException;
import com.IqacBackend.IqacSpringBootfirstapp.model.Book;
//import com.IqacBackend.IqacSpringBootfirstapp.model.Book;
import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
import com.IqacBackend.IqacSpringBootfirstapp.model.ResearchPapers;
import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;
import com.IqacBackend.IqacSpringBootfirstapp.repository.StaffRepository;

@Service
public class StaffService {

	private final StaffRepository staffRepository;
	private final PatentsService patentsService;
	private final BookService bookService;
	private final ResearchPapersService rpService;

	@Autowired
	public StaffService(StaffRepository staffRepository, PatentsService patentsService, BookService bookService,
			ResearchPapersService rpService) {
		this.staffRepository = staffRepository;
		this.patentsService = patentsService;
		this.bookService = bookService;
		this.rpService = rpService;
	}
	
	
	public Staff addStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	

	public List<Staff> getStaff(){
		return StreamSupport
				.stream(staffRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	public List<Patents> getPatents(){
		return patentsService.getPatents();
	}
	
	public List<Book> getBooks(){
		return bookService.getBook();
	}
	
	public List<ResearchPapers> getRp(){
		return rpService.getResearchPapers();
	}
	
	public Staff getStaff(Long id) {
		return staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("staff not exist with id"+id));
	}
	
	public Staff deleteStaff(Long id) {
		 Staff staff = getStaff(id);
		 staffRepository.delete(staff);
		 return staff;
	}
	
	@Transactional
	public Staff editStaff(Long id , Staff staff) {
		Staff staffToEdit = getStaff(id);
		staffToEdit.setEmpNo(staff.getEmpNo());
		staffToEdit.setFullName(staff.getFullName());
		staffToEdit.setAadharNumber(staff.getAadharNumber());
		staffToEdit.setCategory(staff.getCategory());
		staffToEdit.setDob(staff.getDob());
		staffToEdit.setDoj(staff.getDoj());
		staffToEdit.setDor(staff.getDor());
		staffToEdit.setDpmt(staff.getDpmt());
		staffToEdit.setEmailId(staff.getEmailId());
		staffToEdit.setGender(staff.getGender());
		staffToEdit.setIndustrialExp(staff.getIndustrialExp());
		staffToEdit.setPanNumber(staff.getPanNumber());
		staffToEdit.setPhone(staff.getPhone());
		staffToEdit.setPresentPosition(staff.getPresentPosition());
		staffToEdit.setQualification(staff.getQualification());
		staffToEdit.setTeachingExp(staff.getTeachingExp());
		staffToEdit.setPatents(staff.getPatents());
		staffToEdit.setBook(staff.getBook());
		staffToEdit.setRp(staff.getRp());
		return staffToEdit;
	}
	
	@Transactional
	public Staff addPatentToStaff(Long staffId,Long patentId) {
		Staff staff = getStaff(staffId);
		Patents patent = patentsService.getPatent(patentId);
		if(Objects.nonNull(patent.getStaff())) {
			throw new patentIsAlreadyAssignedException(patentId,patent.getStaff().getId());
		}
		staff.addPatent(patent);
		return staff;
	}
	
	@Transactional
	public Staff removePatentFromStaff(Long staffId,Long patentId) {
		Staff staff = getStaff(staffId);
		Patents patent = patentsService.getPatent(patentId);
		patentsService.deletePatent(patentId);
		staff.removePatent(patent);
		return staff;
	}
	
	@Transactional
	public Staff addBookToStaff(Long staffId,Long bookId) {
		Staff staff = getStaff(staffId);
		Book book = bookService.getBook(bookId);
		if(Objects.nonNull(book.getStaff())) {
			throw new patentIsAlreadyAssignedException(bookId,book.getStaff().getId());
		}
		staff.addBook(book);
		return staff;
	}

	@Transactional
	public Staff removeBookFromStaff(Long staffId, Long bookId) {
		// TODO Auto-generated method stub
		Staff staff = getStaff(staffId);
		Book book = bookService.getBook(bookId);
//		bookService.deleteBook(bookId);
		staff.removeBook(book);
		return staff;
	}
	
	@Transactional
	public Staff addResearchPapersToStaff(Long staffId,Long rpId) {
		Staff staff = getStaff(staffId);
		ResearchPapers rp = rpService.getResearchPapers(rpId);
		staff.addResearchPapers(rp);
		return staff; 
	}
	
	@Transactional
	public Staff removeResearchPapersFromStaff(Long staffId, Long rpId) {
		Staff staff = getStaff(staffId);
		ResearchPapers rp = rpService.getResearchPapers(rpId);
		staff.removeResearchPapers(rp);
		return staff;
	}
}



