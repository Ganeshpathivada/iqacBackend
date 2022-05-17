package com.IqacBackend.IqacSpringBootfirstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IqacBackend.IqacSpringBootfirstapp.model.Doc;

@Repository
public interface DocRepository extends JpaRepository<Doc,String>{

}
