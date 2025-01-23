package com.api.base;

import io.restassured.response.Response;

public class ReportService extends BaseService {
	
	public  static final String BASE_PATH = "/api/reports/statement/";
	
	public Response excelreport(String token, String key,String value) 
	{
		setAuthToken(token);
		  return getRequestwithqueryparam(BASE_PATH +"excel", key, value);
	}
	
	public Response pdfreport(String token, String key,String value) 
	{
		setAuthToken(token);
		  return getRequestwithqueryparam(BASE_PATH +"history", key, value);
	}

}
