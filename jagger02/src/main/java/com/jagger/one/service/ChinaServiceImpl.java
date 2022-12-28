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
public class ChinaServiceImpl implements IChinaService {

	@Override
	public ResponseData getPoulation() {

		// source : https://countrymeters.info/en/China
		
		ResponseData responseData = new ResponseData();
		responseData.setTotalFemalePopulation(701426600L);
		responseData.setTotalMalePopulation(757393421L);
		
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		return responseData;
	}

}
