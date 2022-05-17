//package com.IqacBackend.IqacSpringBootfirstapp.controller;
//
//	import java.util.HashMap;
//	import java.util.List;
//	import java.util.Map;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.CrossOrigin;
//	import org.springframework.web.bind.annotation.DeleteMapping;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.PathVariable;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.PutMapping;
//	import org.springframework.web.bind.annotation.RequestBody;
//	import org.springframework.web.bind.annotation.RequestMapping;
//	import org.springframework.web.bind.annotation.RestController;
//
//	import com.IqacBackend.IqacSpringBootfirstapp.exception.ResourceNotFoundException;
//	import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;	
//	import com.IqacBackend.IqacSpringBootfirstapp.repository.PatentsRepository;
//
//	@RestController
//	@CrossOrigin
//	@RequestMapping("/patent")
//	public class PatentsController {
//		
//		@Autowired
//		private PatentsRepository patentRepository;
//		
//		@RequestMapping("/list")
//		public List<Patents> patentsList() {
//			return patentRepository.findAll();
//		}
//		@PostMapping("/patent")
//		public Patents createPatent(@RequestBody Patents patent) {
//			return patentRepository.save(patent);
//		}
//		@GetMapping("/patent/{sb_fid}")
//		public ResponseEntity<Patents> getPatentById(@PathVariable Long id) {
//			Patents patent =patentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("patent not exist with id"+id));
//			return ResponseEntity.ok(patent);
//			
//		}
//		//update staff details
//			@PutMapping("/patent/{sb_fid}")
//			public ResponseEntity<Patents> updatePatent(@PathVariable Long id,@RequestBody Patents patentDetails){
//				Patents patent = patentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("staff not exist with id"+id));
////				staff.setSno(staffDetails.getSno());
//				patent.setNationalOrInternational(patentDetails.getNationalOrInternational());
//				patent.setStatus(patentDetails.getStatus());
//				patent.setTitle(patentDetails.getTitle());
//				patent.setYearOfAward(patentDetails.getYearOfAward());
//				Patents updatedPatent=patentRepository.save(patent);
//				return ResponseEntity.ok(updatedPatent);	
//			}
//		@DeleteMapping("/patent/{sb_fid}")
//		public ResponseEntity<Map<String, Boolean>> deletePatent(@PathVariable Long id){
//			Patents patent = patentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("staff not Exist with id"+id));
//			patentRepository.delete(patent);
//			Map<String, Boolean> response = new HashMap<>();
//			response.put("deleted",Boolean.TRUE);
//			return ResponseEntity.ok(response);
//		}
//	}
package com.IqacBackend.IqacSpringBootfirstapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;
import com.IqacBackend.IqacSpringBootfirstapp.service.PatentsService;

@RestController
@CrossOrigin
@RequestMapping("/patent")
public class PatentsController {
	
	private final PatentsService patentsService;
	@Autowired
	public PatentsController(PatentsService patentsService) {
		this.patentsService = patentsService;
	}
	
//	@PostMapping("/patents")
//	public ResponseEntity<PatentDto> addPatent(@RequestBody  List<PatentDto> patentDto){
//		Patents patent = patentsService.addPatent(Patents.from(patentDto));
//		return new ResponseEntity<>(PatentDto.from(patent),HttpStatus.OK);
//	}
 
	@GetMapping("/patents")
	public ResponseEntity<List<PatentDto>> getPatents(){
		List<Patents> patents = patentsService.getPatents();
		List<PatentDto> patentDto = patents.stream().map(PatentDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(patentDto,HttpStatus.OK);
	}
	@GetMapping(value = "/patents/{id}")
	public ResponseEntity<PatentDto> getPatent(@PathVariable final Long id){
		Patents patent = patentsService.getPatent(id);
		return new ResponseEntity<>(PatentDto.from(patent),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/patents/{id}")
	public ResponseEntity<PatentDto> deletePatent(@PathVariable final Long id){
		Patents patent = patentsService.deletePatent(id);
		return new ResponseEntity<>(PatentDto.from(patent),HttpStatus.OK);
	}
	
	@PutMapping(value = "/patents/{id}")
	public ResponseEntity<PatentDto> editPatent(@PathVariable final Long id, @RequestBody  PatentDto patentDto){
		
		Patents editedPatent = patentsService.editPatent(id, Patents.from(patentDto));
		return new ResponseEntity<>(PatentDto.from(editedPatent),HttpStatus.OK);
	}
	
}


