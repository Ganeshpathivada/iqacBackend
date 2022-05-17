package com.IqacBackend.IqacSpringBootfirstapp.model;


    import java.util.ArrayList;
    import java.util.Date;
    //	import java.util.Date;
	import java.util.List;
    import javax.persistence.CascadeType;
    //	import javax.persistence.Column;
	//import java.util.Date;
	import javax.persistence.Entity;
    import javax.persistence.GeneratedValue; 
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

    import com.IqacBackend.IqacSpringBootfirstapp.model.dto.StaffDto;

    import lombok.Data;


	@Data
	@Entity
	@Table(name ="staff")
	public class Staff {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Long empNo;
		private String fullName;
		private String dpmt;
		private String gender;
		private String category;
		private String presentPosition;
		private Date dob;
		private Date doj;
		private Date dor;
		private String qualification;
		private int teachingExp;
		private int industrialExp;
		private String panNumber;
		private double aadharNumber;
		private long  phone;
		private String emailId;

public String getDpmt() {
			return dpmt;
		}

		public void setDpmt(String dpmt) {
			this.dpmt = dpmt;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getPresentPosition() {
			return presentPosition;
		}

		public void setPresentPosition(String presentPosition) {
			this.presentPosition = presentPosition;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Date getDoj() {
			return doj;
		}

		public void setDoj(Date doj) {
			this.doj = doj;
		}

		public Date getDor() {
			return dor;
		}

		public void setDor(Date dor) {
			this.dor = dor;
		}

		public String getQualification() {
			return qualification;
		}

		public void setQualification(String qualification) {
			this.qualification = qualification;
		}

		public int getTeachingExp() {
			return teachingExp;
		}

		public void setTeachingExp(int teachingExp) {
			this.teachingExp = teachingExp;
		}

		public int getIndustrialExp() {
			return industrialExp;
		}

		public void setIndustrialExp(int industrialExp) {
			this.industrialExp = industrialExp;
		}

		public String getPanNumber() {
			return panNumber;
		}

		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
		}

		public double getAadharNumber() {
			return aadharNumber;
		}

		public void setAadharNumber(double aadharNumber) {
			this.aadharNumber = aadharNumber;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public void setId(Long id) {
			this.id = id;
		}

		//		@Column(name="awards")
//		private String awards;
//		@Column(name="no_of_phd")
//		private int noOfPhd;
//		@Column(name="books_authored")
//		private String booksAuthored;
//		@Column(name="no_of_research_papers")
//		private int noOfResearchPapers;
//		@Column(name="total_no_of_research")
//		private int totalNoOfResearch;
//		@Column(name="patents")
//		private String patents;
//		@OneToMany(cascade = CascadeType.ALL)
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn( name = "staff_id",referencedColumnName = "id")
		private List<Patents> patents;
//		@JoinColumn( name = "staff_id",referencedColumnName = "id")
	
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn( name = "staff_id",referencedColumnName = "id")
		List<Book> books = new ArrayList<>();
		
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn( name = "staff_id",referencedColumnName = "id")
		List<ResearchPapers> rps = new ArrayList<>();
		
		public Staff() {
			
		}		

		public Staff(int sno, long empNo2, String fullName2, String dpmt2, String gender2, String category2,
		String presentPosition2, Date dob2, Date doj2, String qualification2, String panNumber2, double aadharNumber2,
		long phone2, String emailId2) {
        }

		public Long getId() {
			return id;
		}

		public List<Patents> getPatents() {
			return patents;
		}

		public void setPatents(List<Patents> patents) {
			this.patents = patents;
		}

		
		public List<Book> getBook() {
			return books;
		}

		public void setBook(List<Book> book) {
			this.books = book;
		}
		
		

		public List<ResearchPapers> getRp() {
			return rps;
		}

		public void setRp(List<ResearchPapers> rps) {
			this.rps = rps;
		}

		public String getFullName() {
			return fullName;
		}

		public Long getEmpNo() {
			return empNo;
		}

		public void setEmpNo(Long empNo) {
			this.empNo = empNo;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}		
		public void addPatent(Patents patent) {
			patents.add(patent);
		}
		public void removePatent(Patents patent) {
			patents.remove(patent);
		}
		
		public void addBook(Book book) {
			books.add(book);
		}
		
		public void removeBook(Book book) {
			books.remove(book);
		}
		
		
		public void addResearchPapers(ResearchPapers rp) {
			rps.add(rp);
		}
		
		public void removeResearchPapers(ResearchPapers rp) {
			rps.remove(rp);
		}
		
		
		public static Staff from (StaffDto staffDto) {
			Staff staff = new Staff();
			staff.setEmpNo(staffDto.getEmpNo());
			staff.setFullName(staffDto.getName());
			staff.setAadharNumber(staffDto.getAadharNumber());
			staff.setCategory(staffDto.getCategory());
			staff.setDob(staffDto.getDob());
			staff.setDoj(staffDto.getDoj());
			staff.setDor(staffDto.getDor());
			staff.setDpmt(staffDto.getDpmt());
			staff.setEmailId(staffDto.getEmailId());
			staff.setGender(staffDto.getGender());
			staff.setIndustrialExp(staffDto.getIndustrialExp());
			staff.setPanNumber(staffDto.getPanNumber());
			staff.setPhone(staffDto.getPhone());
			staff.setPresentPosition(staffDto.getPresentPosition());
			staff.setQualification(staffDto.getQualification());
			staff.setTeachingExp(staffDto.getTeachingExp());
			staff.setPatents(Patents.from(staffDto.getPatentDto()));
			staff.setBook(Book.from(staffDto.getBookDto()));
			staff.setRp(ResearchPapers.from(staffDto.getRpDto()));
			return staff;
		}
		
	}
