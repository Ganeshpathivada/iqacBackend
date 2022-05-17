package com.IqacBackend.IqacSpringBootfirstapp.model.dto;

import com.IqacBackend.IqacSpringBootfirstapp.model.Ranking;

import lombok.Data;

@Data
public class RankingDto {
	
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

	public static RankingDto from(Ranking ranking) {
		RankingDto rankingDto = new RankingDto();
		rankingDto.setId(ranking.getId());
		rankingDto.setRank1(ranking.getRank1());
		rankingDto.setYear(ranking.getYear());
		rankingDto.setType1(ranking.getType1());
		return rankingDto;
	}

}
