/*
 * 2022-12-26
 */
package com.jagger.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagger.one.dto.ResultResponse;
import com.jagger.one.service.IAggregateResultService;

/**
 * @author Pradeep
 *
 */
@RestController
@RequestMapping("population")
public class AggregateResultController {

	@Autowired
	private IAggregateResultService aggrResult;
	
	@RequestMapping("/hi")
	public ResponseEntity<String> greetings(){
		return ResponseEntity.ok("Hi welcome to my API");
	} 
	
	@RequestMapping("/")
	public ResponseEntity<ResultResponse> getResult() throws Exception{
//		ResultResponse response = aggrResult.getPopulation();
		ResultResponse response = aggrResult.getPopulationParllel();
		return ResponseEntity.ok(response);
	} 
}
