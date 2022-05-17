package com.IqacBackend.IqacSpringBootfirstapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IqacBackend.IqacSpringBootfirstapp.model.Ranking;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long>{

}
