package com.IqacBackend.IqacSpringBootfirstapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IqacBackend.IqacSpringBootfirstapp.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}