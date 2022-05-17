package com.IqacBackend.IqacSpringBootfirstapp.repository;

//	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
	import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;

	@Repository
	public interface StaffRepository extends CrudRepository<Staff, Long> {

	}
