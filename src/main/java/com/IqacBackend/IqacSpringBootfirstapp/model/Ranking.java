package com.IqacBackend.IqacSpringBootfirstapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.IqacBackend.IqacSpringBootfirstapp.model.dto.RankingDto;

import lombok.Data;

@Data
@Entity
@Table(name = "Ranking")
public class Ranking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String year;
	private int rank1;
	private String type1; 
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getRank1() {
		return rank1;
	}
	public void setRank1(int rank1) {
		this.rank1 = rank1;
	}
	
	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public static Ranking from(RankingDto rankingDto) {
		Ranking ranking = new Ranking();
		ranking.setYear(rankingDto.getYear());
		ranking.setRank1(rankingDto.getRank1());
		ranking.setType1(rankingDto.getType1());
		return ranking;
	}
}
