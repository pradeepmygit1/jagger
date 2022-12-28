/*
 * 2022-12-26
 */
package com.jagger.one.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jagger.one.dto.ResponseData;
import com.jagger.one.dto.ResultResponse;

/**
 * @author Pradeep
 *
 */
@Service
public class AggregateResultServiceImpl implements IAggregateResultService {

	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResultResponse getPopulation() throws Exception {

		String chinaPop = "http://localhost:8082/china";
		String indiaPop = "http://localhost:8083/india";
		String usaPop = "http://localhost:8084/usa";
		// http://localhost:8081/population/hi
		ResultResponse response = new ResultResponse();
		// response.setTotalFemalePopulation(1000L);
		// response.setTotalMalePopulation(900L);
		
		StopWatch stWatch = new StopWatch("FatchAllApis");
		stWatch.start("ALL");

		try {

			ResponseData responseDataChina = restTemplateBuilder.build().getForObject(chinaPop, ResponseData.class);

			ResponseData responseDataIndia = restTemplateBuilder.build().getForObject(indiaPop, ResponseData.class);

			ResponseData responseDataUsa = restTemplateBuilder.build().getForObject(usaPop, ResponseData.class);

			response.setTotalFemalePopulation(responseDataChina.getTotalFemalePopulation()
					+ responseDataIndia.getTotalFemalePopulation() + responseDataUsa.getTotalFemalePopulation());

			response.setTotalMalePopulation(responseDataChina.getTotalMalePopulation()
					+ responseDataIndia.getTotalMalePopulation() + responseDataUsa.getTotalMalePopulation());

		} catch (RestClientException restExp) {
			restExp.printStackTrace();
			throw restExp;
		}

		stWatch.stop();
		System.out.println(" ------------took total: " + stWatch.getTotalTimeSeconds() + " seconds");
		System.out.println("---------------Summary : "+stWatch.shortSummary());
		System.out.println("LastTask Milli Seconds : "+stWatch.getLastTaskTimeMillis());
		
		return response;
	}

	@Override
	public ResultResponse getPopulationParllel() throws Exception {

		String chinaPop = "http://CHINA-MICROSERVICE/china";
		String indiaPop = "http://INDIA-MICROSERVICE/india";
		String usaPop = "http://USA-MICROSERVICE/usa";
		
		ResultResponse response = new ResultResponse();

		List<Future<ResponseData>> li = new ArrayList<Future<ResponseData>>();

		ExecutorService exService = Executors.newFixedThreadPool(3);

		MyCallable mycall1 = new MyCallable();

		mycall1.setRestTemplate(restTemplate);
		mycall1.setRestTemplateBuilder(restTemplateBuilder);
		mycall1.setServiceUrl(chinaPop);

		MyCallable mycall2 = new MyCallable();

		mycall2.setRestTemplate(restTemplate);
		mycall2.setRestTemplateBuilder(restTemplateBuilder);
		mycall2.setServiceUrl(indiaPop);

		MyCallable mycall3 = new MyCallable();

		mycall3.setRestTemplate(restTemplate);
		mycall3.setRestTemplateBuilder(restTemplateBuilder);
		mycall3.setServiceUrl(usaPop);
		
		System.out.println("before stop watch");
		// StopWatch stWatch = new StopWatch();
		// stWatch.start("FatchAll");

		try {

			li.add(exService.submit(mycall1));
			li.add(exService.submit(mycall2));
			li.add(exService.submit(mycall3));

			for (Future<ResponseData> future : li) {
				ResponseData rData = future.get();
				 
				response.setTotalFemalePopulation(rData.getTotalFemalePopulation() + ((response.getTotalFemalePopulation() == null )? 0 : response.getTotalFemalePopulation()));
				response.setTotalMalePopulation(rData.getTotalMalePopulation() + (( response.getTotalMalePopulation() == null )? 0 : response.getTotalMalePopulation() ));
			}

		} catch (RestClientException restExp) {
			restExp.printStackTrace();
			throw restExp;
		}

		/*
		 * stWatch.stop();
		 * System.out.println(" ------------took total: " +
		 * stWatch.getTotalTimeSeconds() + " seconds");
		 * System.out.println("---------------Summary : "+stWatch.shortSummary());
		 * System.out.println("LastTask Milli Seconds : "+stWatch.getLastTaskTimeMillis(
		 * )); System.out.println("After stop watch");
		 */
		return response;
	}

}
