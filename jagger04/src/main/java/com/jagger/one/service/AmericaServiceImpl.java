/*
 * 2022-12-26
 */
package com.jagger.one.service;

import org.springframework.stereotype.Service;

import com.jagger.one.dto.ResponseData;

/**
 * @author Pradeep
 *
 */
@Service
public class AmericaServiceImpl implements IAmericaService {

	@Override
	public ResponseData getPoulation() {

		// source : https://countrymeters.info/en/United_States_of_America_(USA)
		
		ResponseData responseData = new ResponseData();
		responseData.setTotalFemalePopulation(170893636L);
		responseData.setTotalMalePopulation(166623003L);
				
		return responseData;
	}

}
