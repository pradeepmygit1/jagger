/*
 * 2022-12-26
 */
package com.jagger.one.service;

import com.jagger.one.dto.ResultResponse;

/**
 * @author Pradeep
 *
 */
public interface IAggregateResultService {
	
	public ResultResponse getPopulation() throws Exception;

	/**
	 * @return
	 * @throws Exception
	 */
	ResultResponse getPopulationParllel() throws Exception;

}
