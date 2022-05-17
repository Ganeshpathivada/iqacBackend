package com.IqacBackend.IqacSpringBootfirstapp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IqacBackend.IqacSpringBootfirstapp.exception.ResourceNotFoundException;
import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
import com.IqacBackend.IqacSpringBootfirstapp.repository.PatentsRepository;

@Service
public class PatentsService {
	private final PatentsRepository patentsRepository;

	@Autowired
	public PatentsService(PatentsRepository patentsRepository) {
		this.patentsRepository = patentsRepository;
	}
	public Patents addPatent(Patents patent) {
		return patentsRepository.save(patent);
	}
	
	public Iterable<Patents> addPatent(List<Patents> patent) {
		return patentsRepository.saveAll(patent);
	}
	
	public List<Patents> getPatents(){
		return StreamSupport
				.stream(patentsRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	public Patents getPatent(Long id) {
		return patentsRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("patent not exist with id"+id));
	}
	
	public Patents deletePatent(Long id) {
		Patents patent = getPatent(id);
		patentsRepository.delete(patent);
		return patent;
	}
	
	@Transactional
	public Patents editPatent(Long id,Patents patent) {
		Patents patentToEdit = getPatent(id);
//		patentToEdit.setSerialNumber(patent.getSerialNumber());
		patentToEdit.setNationalOrInternational(patent.getNationalOrInternational());
		patentToEdit.setStatus(patent.getStatus());
		patentToEdit.setTitle(patent.getTitle());
		patentToEdit.setYearOfAward(patent.getYearOfAward());
		return patentToEdit;
	}
}
