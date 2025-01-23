package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.listeners.TestListener;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		
		  logRequest(requestSpec);
		  Response response = ctx.next(requestSpec, responseSpec);
		  
		  logResponse(response);
		  
		return  response;
	}
	
	private void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI:" +requestSpec.getBaseUri() );
        logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        logger.info("Headers: {}", requestSpec.getHeaders());
        logger.info("Request Payload: {}"+requestSpec.getBody());
    }

    private void logResponse(Response response) {
    	logger.info("Response Status Code: {}", response.getStatusCode());
    	logger.info("Response Header: {}", response.getHeaders());
        logger.info("Response Body:"+ response.getBody().asPrettyString());
      //  logger.info("Response Body: {}", response.getBody().asString());
    }
	

}
