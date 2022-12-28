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
public class IndiaServiceImpl implements IIndiaService {

	@Override
	public ResponseData getPoulation() {
		
		// source : https://countrymeters.info/en/India
		
		ResponseData responseData = new ResponseData();
		responseData.setTotalFemalePopulation(689491358L);
		responseData.setTotalMalePopulation(736038944L);
		
		return responseData;
	}

}
