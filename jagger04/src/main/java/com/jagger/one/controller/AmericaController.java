/*
 * 2022-12-26
 */
package com.jagger.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jagger.one.dto.ResponseData;
import com.jagger.one.service.IAmericaService;

/**
 * @author Pradeep
 *
 */
@RestController
@RequestMapping("usa")
public class AmericaController {

	@Autowired
    private IAmericaService americaService;
    
	@RequestMapping("/hi")
	public ResponseEntity<String> greetings(){
		return ResponseEntity.ok("Hi , Welcome to America API");
	}
	
	@RequestMapping
	public ResponseEntity<ResponseData> getPopulationInfo(){
		
		ResponseEntity<ResponseData> response = null; // 
		ResponseData responsData = americaService.getPoulation();
		response =  ResponseEntity.ok(responsData);
		return response;
	}
}
