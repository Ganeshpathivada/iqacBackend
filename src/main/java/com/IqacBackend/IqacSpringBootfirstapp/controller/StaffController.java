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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IqacBackend.IqacSpringBootfirstapp.model.Book;
import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
import com.IqacBackend.IqacSpringBootfirstapp.model.ResearchPapers;
import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.BookDto;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.ResearchPapersDto;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.StaffDto;
import com.IqacBackend.IqacSpringBootfirstapp.service.PatentsService;
import com.IqacBackend.IqacSpringBootfirstapp.service.StaffService;

	@RestController
	@CrossOrigin
	@RequestMapping("/api/v1")	
	public class StaffController {
		private final StaffService staffService;
		private final PatentsService patentsService;
		@Autowired
		public StaffController(StaffService staffService, PatentsService patentsService) {
			this.staffService = staffService;
			this.patentsService = patentsService;
		}
		
		@PostMapping("/staff")
		public ResponseEntity<StaffDto> addStaff(@RequestBody final StaffDto staffDto){
			Staff staff = staffService.addStaff(Staff.from(staffDto));
			return new ResponseEntity<>(StaffDto.from(staff), HttpStatus.OK);
		}
		
		@GetMapping("/staff")
		public ResponseEntity<List<StaffDto>> getStaff(){
			List<Staff> staff = staffService.getStaff();
			
			List<StaffDto> staffDto = staff.stream().map(StaffDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(staffDto, HttpStatus.OK);
		}
		
		@GetMapping("/staff/{id}")
		public ResponseEntity<StaffDto> getStaff(@PathVariable final Long id){
			Staff staff = staffService.getStaff(id);
			System.out.print("patent" + staff.getDob());
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
		
		@DeleteMapping(value = "/staff/{id}")
		public ResponseEntity<StaffDto> deleteStaff(@PathVariable final Long id){
			Staff staff = staffService.deleteStaff(id);
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
		
		@PutMapping(value = "/staff/{id}")
		public ResponseEntity<StaffDto> editStaff(@PathVariable final Long id, @RequestBody final StaffDto staffDto){
			Staff staff = staffService.editStaff(id, Staff.from(staffDto));
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
		

		@GetMapping("staff/{staffId}/patents")
		public ResponseEntity<List<PatentDto>> getPatents(@PathVariable final Long staffId){
			Staff staff = staffService.getStaff(staffId);
			List<Patents> patents = staff.getPatents();
			List<PatentDto> patentDto = patents.stream().map(PatentDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(patentDto,HttpStatus.OK);
		}
		@GetMapping("staff/{staffId}/patents/{patentId}")
		public ResponseEntity<Patents> getPatents(@PathVariable final Long staffId,@PathVariable final Long patentId){
			
			Patents patents = patentsService.getPatent(patentId);
//			List<PatentDto> patentDto = patents.stream().map(PatentDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(patents,HttpStatus.OK);
		}
		
//		@PostMapping(value = "/staff/{staffId}/patents/{patentId}/add")
//		public ResponseEntity<StaffDto> addPatentToStaff(@PathVariable final Long staffId,@PathVariable final Long patentId){
//			Staff staff = staffService.addPatentToStaff(staffId, patentId);
//			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//		}
		@DeleteMapping(value = "/staff/{staffId}/book/{bookId}")
		public ResponseEntity<StaffDto> removeBookFromStaff(@PathVariable final Long staffId,@PathVariable final Long bookId){
			Staff staff = staffService.removeBookFromStaff (staffId, bookId);
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
		
		@GetMapping("staff/{staffId}/books")
		public ResponseEntity<List<BookDto>> getBook(@PathVariable final Long staffId){
			Staff staff = staffService.getStaff(staffId);
			List<Book> book = staff.getBook();
			List<BookDto> bookDto = book.stream().map(BookDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(bookDto,HttpStatus.OK);
		}
		
		@DeleteMapping(value = "/staff/{staffId}/rp/{rpId}")
		public ResponseEntity<StaffDto> removeResearchPapersFromStaff(@PathVariable final Long staffId,@PathVariable final Long rpId){
			Staff staff = staffService.removeResearchPapersFromStaff (staffId, rpId);
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
//		
		@GetMapping("staff/{staffId}/rp")
		public ResponseEntity<List<ResearchPapersDto>> getResearchPapers(@PathVariable final Long staffId){
			Staff staff = staffService.getStaff(staffId);
			List<ResearchPapers> rp = staff.getRp();
			List<ResearchPapersDto> rpDto = rp.stream().map(ResearchPapersDto::from).collect(Collectors.toList());
			return new ResponseEntity<>(rpDto,HttpStatus.OK);
		}
////		
//		
//		@GetMapping("staff/{staffId}/patents/{patentId}")
//		public ResponseEntity<Patents> getPatents(@PathVariable final Long staffId,@PathVariable final Long patentId){
//			
//			Patents patents = patentsService.getPatent(patentId);
////			List<PatentDto> patentDto = patents.stream().map(PatentDto::from).collect(Collectors.toList());
//			return new ResponseEntity<>(patents,HttpStatus.OK);
//		}
		@DeleteMapping(value = "/staff/{staffId}/patents/{patentId}")
		public ResponseEntity<StaffDto> removePatentFromStaff(@PathVariable final Long staffId,@PathVariable final Long patentId){
			Staff staff = staffService.removePatentFromStaff (staffId, patentId);
			return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
		}
	}
	
	
	
	//package com.IqacBackend.IqacSpringBootfirstapp.controller;
	//
	//import java.util.List;
	//import java.util.stream.Collectors;
	//
	//import org.springframework.beans.factory.annotation.Autowired;
	//import org.springframework.http.HttpStatus;
	//import org.springframework.http.ResponseEntity;
	//import org.springframework.web.bind.annotation.CrossOrigin;
	//import org.springframework.web.bind.annotation.DeleteMapping;
	//import org.springframework.web.bind.annotation.GetMapping;
	//import org.springframework.web.bind.annotation.PathVariable;
	//import org.springframework.web.bind.annotation.PostMapping;
	//import org.springframework.web.bind.annotation.PutMapping;
	//import org.springframework.web.bind.annotation.RequestBody;
	//import org.springframework.web.bind.annotation.RequestMapping;
	//import org.springframework.web.bind.annotation.RestController;
	//
	//import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
	////import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
	////import com.IqacBackend.IqacSpringBootfirstapp.model.Patents;
	//import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;
	//import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;
	////import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;
	////import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;
	//import com.IqacBackend.IqacSpringBootfirstapp.model.dto.StaffDto;
	//import com.IqacBackend.IqacSpringBootfirstapp.service.StaffService;
	//
//		@RestController
//		@CrossOrigin
//		@RequestMapping("/api/v1")	
//		public class StaffController {
//			private final StaffService staffService;
//			@Autowired
//			public StaffController(StaffService staffService) {
//				this.staffService = staffService;
//			}
//			
//			@PostMapping("/staff")
//			public ResponseEntity<StaffDto> addStaff(@RequestBody final StaffDto staffDto){
//				Staff staff = staffService.addStaff(Staff.from(staffDto));
//				return new ResponseEntity<>(StaffDto.from(staff), HttpStatus.OK);
//			}
//			
//			@GetMapping("/staff")
//			public ResponseEntity<List<StaffDto>> getStaff(){
//				List<Staff> staff = staffService.getStaff();
//				List<StaffDto> staffDto = staff.stream().map(StaffDto::from).collect(Collectors.toList());
//				return new ResponseEntity<>(staffDto, HttpStatus.OK);
//			}
//			
//			@GetMapping("/staff/{id}")
//			public ResponseEntity<StaffDto> getStaff(@PathVariable final Long id){
//				Staff staff = staffService.getStaff(id);
//				return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//			}
//			
//			@DeleteMapping(value = "/staff/{id}")
//			public ResponseEntity<StaffDto> deleteStaff(@PathVariable final Long id){
//				Staff staff = staffService.deleteStaff(id);
//				return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//			}
//			
//			@PutMapping(value = "/staff/{id}")
//			public ResponseEntity<StaffDto> editStaff(@PathVariable final Long id, @RequestBody final StaffDto staffDto){
//				Staff staff = staffService.editStaff(id, Staff.from(staffDto));
//				return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//			}
////			patents.stream().map(PatentDto::from).collect(Collectors.toList());
//			@GetMapping("staff/{staffId}/patents")
//			public ResponseEntity<List<PatentDto>> getPatents(){
//				List<Patents> patents = staffService.getPatents();
//				List<PatentDto> patentDto = patents.stream().map(PatentDto::from).collect(Collectors.toList());
//				return new ResponseEntity<>(patentDto,HttpStatus.OK);
//			}
//			
//			@PostMapping(value = "/staff/{staffId}/patents/{patentId}/add")
//			public ResponseEntity<StaffDto> addPatentToStaff(@PathVariable final Long staffId,@PathVariable final Long patentId){
//				Staff staff = staffService.addPatentToStaff(staffId, patentId);
//				return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//			}
//			
//			@DeleteMapping(value = "/staff/{staffId}/patents/{patentId}")
//			public ResponseEntity<StaffDto> removePatentFromStaff(@PathVariable final Long staffId,@PathVariable final Long patentId){
//				Staff staff = staffService.removePatentFromStaff (staffId, patentId);
//				return new ResponseEntity<>(StaffDto.from(staff),HttpStatus.OK);
//			}
//		}

