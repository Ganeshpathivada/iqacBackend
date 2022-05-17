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

import com.IqacBackend.IqacSpringBootfirstapp.model.Ranking;
import com.IqacBackend.IqacSpringBootfirstapp.model.dto.RankingDto;
import com.IqacBackend.IqacSpringBootfirstapp.service.RankingService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class RankingController {

	private final RankingService rankingService;

	
	@Autowired
	public RankingController(RankingService rankingService) {
		
		this.rankingService = rankingService;
	}

	@PostMapping("/rank")
	public ResponseEntity<RankingDto> addRanking(@RequestBody  RankingDto rankingDto){
		Ranking ranking = rankingService.addRanking(Ranking.from(rankingDto));
		return new ResponseEntity<>(RankingDto.from(ranking),HttpStatus.OK);
	}
	@GetMapping("/rank")
	public ResponseEntity<List<RankingDto>> getRanking(){
		List<Ranking> ranking = rankingService.getRanking();
		List<RankingDto> rankingDto = ranking.stream().map(RankingDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(rankingDto,HttpStatus.OK);
	}
	
	@PutMapping(value = "/rank/{id}")
	public ResponseEntity<RankingDto> editRanking(@PathVariable final Long id, @RequestBody  RankingDto rankingDto){
		
		Ranking editedRanking = rankingService.editRanking(id, Ranking.from(rankingDto));
		return new ResponseEntity<>(RankingDto.from(editedRanking),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/rank/{id}")
	public ResponseEntity<RankingDto> deleteRanking(@PathVariable final Long id){
		Ranking ranking = rankingService.deleteRanking(id);
		return new ResponseEntity<>(RankingDto.from(ranking),HttpStatus.OK);
	}
}
