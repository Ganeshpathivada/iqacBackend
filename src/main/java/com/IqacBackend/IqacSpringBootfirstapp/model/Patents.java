package com.IqacBackend.IqacSpringBootfirstapp.model;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.Date;
//import java.util.List;
import java.util.List;
import java.util.Set;

//	import java.util.Date;

//	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.IqacBackend.IqacSpringBootfirstapp.model.dto.PatentDto;

import lombok.Data;

	@Data
	@Entity
	@Table(name = "patents")
	public class Patents {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String title;
		private long yearOfAward;
		private String nationalOrInternational;
		private String status;
//		@ManyToOne
		
		@ManyToOne
//		@JoinColumn(name = "staff_id")
		private Staff staff;
//		private IdeaProfile ideaProfile;
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
        public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public long getYearOfAward() {
			return yearOfAward;
		}
		public void setYearOfAward(long yearOfAward) {
			this.yearOfAward = yearOfAward;
		}
		public String getNationalOrInternational() {
			return nationalOrInternational;
		}
		public void setNationalOrInternational(String nationalOrInternational) {
			this.nationalOrInternational = nationalOrInternational;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public static Patents from(PatentDto patentDto) {
			Patents patent = new Patents();
			patent.setNationalOrInternational(patentDto.getNationalOrInternational());
			patent.setStatus(patentDto.getStatus());
			patent.setTitle(patentDto.getTitle());
			patent.setYearOfAward(patentDto.getYearOfAward());
			return patent;
		}
		
		public static List<Patents> from(List<PatentDto> patentDto) {
			List<Patents> patent = new ArrayList<Patents>();
			for(PatentDto p :patentDto) {
				Patents obj = new Patents();
				obj.setNationalOrInternational(p.getNationalOrInternational());
				obj.setStatus(p.getStatus());
				obj.setTitle(p.getTitle());
				obj.setYearOfAward(p.getYearOfAward());
				patent.add(obj);
			}
			return patent;	
		}
		
	}


