/*
 * 2022-12-26
 */
package com.jagger.one.dto;

import java.io.Serializable;

/**
 * @author Pradeep
 *
 */
public class ResultResponse implements Serializable{
	
	private Long totalPopulation;
	private Long totalMalePopulation;
	private Long totalFemalePopulation;
	
	public Long getTotalPopulation() {
		this.totalPopulation = this.totalFemalePopulation + this.totalMalePopulation;
		return totalPopulation;
	}
	public void setTotalPopulation(Long totalPopulation) {
		this.totalPopulation = totalPopulation;
	}
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
