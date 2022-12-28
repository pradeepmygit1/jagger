/*
 * 2022-12-27
 */
package com.jagger.one.service;

import java.util.concurrent.Callable;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.jagger.one.dto.ResponseData;

/**
 * @author Pradeep
 *
 */

public class MyCallable implements Callable<ResponseData>{
	
	private RestTemplateBuilder restTemplateBuilder;
	
	private RestTemplate restTemplate;
	
	private String serviceUrl;
	
	@Override
	public ResponseData call() throws Exception {
		//return restTemplateBuilder.build().getForObject(serviceUrl, ResponseData.class);
		return restTemplate.getForObject(serviceUrl, ResponseData.class);
		
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public void setRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}


	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	
}
