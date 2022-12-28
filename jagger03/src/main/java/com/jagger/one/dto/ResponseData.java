/*
 * 2022-12-26
 */
package com.jagger.one.dto;

/**
 * @author Pradeep
 *
 */
public class ResponseData {
	
	private Long totalMalePopulation;
	private Long totalFemalePopulation;
	
	public Long getTotalMalePopulation() {
		return totalMalePopulation;
	}
	public void setTotalMalePopulation(Long totalMalePopulation) {
		this.totalMalePopulation = totalMalePopulation;
	}
	public Long getTotalFemalePopulation() {
		return totalFemalePopulation;
	}
	public void setTotalFemalePopulation(Long totalFemalePopulation) {
		this.totalFemalePopulation = totalFemalePopulation;
	}
	
}
